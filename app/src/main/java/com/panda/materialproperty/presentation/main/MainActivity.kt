package com.panda.materialproperty.presentation.main

import android.content.res.ColorStateList
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentManager
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.panda.materialproperty.R
import com.panda.materialproperty.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fm = supportFragmentManager

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.navOptions.itemTextColor =
                ColorStateList.valueOf(
                    ResourcesCompat.getColor(resources, R.color.white, theme)
                )

        binding.navOptions.itemBackground =
                ResourcesCompat.getDrawable(resources, R.drawable.separator, theme)




        with(binding) {

        }
    }

    override fun onClick(v: View) {
        Snackbar.make(binding.root, v.id.toString(), Snackbar.LENGTH_SHORT).show()
    }


}
