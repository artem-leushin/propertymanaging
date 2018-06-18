package com.panda.materialproperty.presentation.enterprises

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panda.materialproperty.R
import com.panda.materialproperty.databinding.FragmentEnterprisesBinding


/**
 * Created by A.Olkinitskaya on 18.06.2018.
 */
class EnterprisesFragment : Fragment(), EnterprisesContract.View {

    private var binding: FragmentEnterprisesBinding? = null
    private var presenter: EnterprisesContract.Presenter? = null

    private val locationName: String by lazy {
        arguments?.getString("locationName", "")!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        presenter = EnterprisesPresenter(
//            this,
//            LoadAllEnterprisesUseCase(EnterprisesRepositoryImpl(Enterprises))
//        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_enterprises, container, false)

        with(binding!!) {
            tvLocationName.text = locationName

            rvEnterprises.layoutManager = LinearLayoutManager(context)

        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun render(viewState: EnterprisesContract.View.State) {
        TODO("not implemented")
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