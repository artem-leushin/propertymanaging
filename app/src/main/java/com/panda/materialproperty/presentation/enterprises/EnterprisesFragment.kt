package com.panda.materialproperty.presentation.enterprises

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panda.materialproperty.App
import com.panda.materialproperty.R
import com.panda.materialproperty.data.repository.EnterprisesRepositoryImpl
import com.panda.materialproperty.databinding.FragmentEnterprisesBinding
import com.panda.materialproperty.domain.interactor.LoadAllEnterprisesUseCase
import com.panda.materialproperty.domain.interactor.LoadEnterprisesAtLocationUseCase
import org.jetbrains.anko.design.snackbar


/**
 * Created by A.Olkinitskaya on 18.06.2018.
 */
class EnterprisesFragment : Fragment(), EnterprisesContract.View {

    private var binding: FragmentEnterprisesBinding? = null
    private var presenter: EnterprisesContract.Presenter? = null

    private val locationName: String by lazy {
        arguments?.getString("locationName", "")!!
    }

    // TODO refactor dao provision with factory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = EnterprisesPresenter(
            this,

            LoadAllEnterprisesUseCase(
                EnterprisesRepositoryImpl(
                    (context?.applicationContext as App).database!!.enterprisesDao()
                )
            ),

            LoadEnterprisesAtLocationUseCase(
                EnterprisesRepositoryImpl(
                    (context?.applicationContext as App).database!!.enterprisesDao()
                )
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_enterprises, container, false)

        return binding!!.apply {
            tvLocationName.text = locationName

            with(rvEnterprises) {
                layoutManager = LinearLayoutManager(context)
                adapter = EnterprisesAdapter()
            }
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.loadAllEnterprises()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        presenter?.disposables?.clear()
    }

    override fun render(viewState: EnterprisesContract.View.State) {
        viewState.error?.let {
            snackbar(binding!!.root, viewState.error.message.toString())
        }

        binding!!.pbProgress.visibility =
                if (viewState.loading) View.VISIBLE
                else View.INVISIBLE

        if (viewState.noContent) {
            binding!!.groupNoContent.visibility = View.VISIBLE
            binding!!.rvEnterprises.visibility = View.INVISIBLE
        } else {
            binding!!.groupNoContent.visibility = View.INVISIBLE
            binding!!.rvEnterprises.visibility = View.VISIBLE
        }

        (binding!!.rvEnterprises.adapter as EnterprisesAdapter).submitList(viewState.enterprises)
    }


    companion object {
        fun newInstance(locationName: String): EnterprisesFragment {
            return EnterprisesFragment()
                .apply {
                    val args = Bundle()
                    args.putString("locationName", locationName)
                    arguments = args
                }
        }
    }
}