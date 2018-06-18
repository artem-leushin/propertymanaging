package com.panda.materialproperty.presentation.main

import android.content.res.ColorStateList
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.panda.materialproperty.R
import com.panda.materialproperty.databinding.ActivityMainBinding
import com.panda.materialproperty.presentation.enterprises.EnterprisesFragment
import com.panda.materialproperty.presentation.inTransaction


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fm = supportFragmentManager

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {

            navOptions.itemTextColor =
                    ColorStateList.valueOf(
                        ResourcesCompat.getColor(resources, R.color.white, theme)
                    )

            navOptions.itemBackground =
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.bg_selector_menu_item_clicable,
                        theme
                    )

            navOptions.setNavigationItemSelectedListener {
                drawer.closeDrawer(Gravity.START)
                navOptions.setCheckedItem(it.itemId)

                fm.inTransaction {
                    replace(
                        R.id.main_content,
                        EnterprisesFragment.newInstance(it.title.toString()),
                        "EnterprisesFragment"
                    )
                }
                true
            }

            fm.inTransaction {
                navOptions.setCheckedItem(R.id.nav_sharaga)
                add(
                    R.id.main_content,
                    EnterprisesFragment.newInstance(getString(R.string.street_sharaga)),
                    "EnterprisesFragment"
                )
            }
        }
    }


}
