package com.panda.materialproperty.presentation.enterprises

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panda.materialproperty.R
import com.panda.materialproperty.data.EnterprisesDatabase
import com.panda.materialproperty.data.SP_STORE
import com.panda.materialproperty.data.repository.EnterprisesDaoImpl
import com.panda.materialproperty.data.repository.EnterprisesRepositoryImpl
import com.panda.materialproperty.databinding.FragmentEnterprisesBinding
import com.panda.materialproperty.domain.interactor.LoadAllEnterprisesUseCase
import com.panda.materialproperty.domain.interactor.LoadEnterprisesAtLocationUseCase
import com.panda.materialproperty.domain.interactor.LogoutUseCase
import org.jetbrains.anko.design.snackbar


/**
 * Created by A.Olkinitskaya on 18.06.2018.
 */
class EnterprisesFragment : Fragment(), EnterprisesContract.View {

    private var binding: FragmentEnterprisesBinding? = null
    private var presenter: EnterprisesContract.Presenter? = null


    private val address: String by lazy {
        arguments?.getString("address", "")!!
    }

    // TODO refactor dao provision with factory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = EnterprisesPresenter(
            this,

            LoadAllEnterprisesUseCase(
                EnterprisesRepositoryImpl(
                    EnterprisesDaoImpl(EnterprisesDatabase(context!!))
                )
            ),

            LoadEnterprisesAtLocationUseCase(
                EnterprisesRepositoryImpl(
                    EnterprisesDaoImpl(EnterprisesDatabase(context!!))
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

        binding!!.apply {
            val title = getString(R.string.eterprises_address_title, address)

            tvLocationName.text = SpannableStringBuilder(title).apply {
                setSpan(RelativeSizeSpan(1.3f), 0, 21, 0)
            }

            with(rvEnterprises) {
                layoutManager = LinearLayoutManager(context)
                adapter = EnterprisesAdapter()
            }

        }

        presenter?.loadEnterprisesAt(address)

        return binding!!.root
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
            binding!!.ivEmpty.visibility = View.VISIBLE
            binding!!.tvEmpty.visibility = View.VISIBLE
//            binding!!.groupNoContent.visibility = View.VISIBLE
            binding!!.rvEnterprises.visibility = View.INVISIBLE
        } else {
            binding!!.ivEmpty.visibility = View.INVISIBLE
            binding!!.tvEmpty.visibility = View.INVISIBLE
//            binding!!.groupNoContent.visibility = View.INVISIBLE
            binding!!.rvEnterprises.visibility = View.VISIBLE
        }

        (binding!!.rvEnterprises.adapter as EnterprisesAdapter).submitList(viewState.enterprises)
    }


    companion object {
        fun newInstance(locationName: String): EnterprisesFragment {
            return EnterprisesFragment()
                .apply {
                    val args = Bundle()
                    args.putString("address", locationName)
                    arguments = args
                }
        }
    }
}