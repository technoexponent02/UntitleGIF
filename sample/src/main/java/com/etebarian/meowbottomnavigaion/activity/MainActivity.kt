package com.etebarian.meowbottomnavigaion.activity

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.etebarian.meowbottomnavigaion.R
import com.etebarian.meowbottomnavigaion.generator.ScreenOneGenerator
import com.etebarian.meowbottomnavigaion.generator.ScreenThreeGenerator
import com.etebarian.meowbottomnavigaion.generator.ScreenTwoGenerator
import com.etebarian.meowbottomnavigaion.model.ScreenBO
import com.etebarian.meowbottomnavigaion.screen.Screen
import com.etebarian.meowbottomnavigaion.screen.ScreenFour
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val SCREEN_ONE_STATUS = 0
    private val SCREEN_TWO_STATUS = 1
    private val SCREEN_THREE_STATUS = 2
    private val SCREEN_FOUR_STATUS = 3

    private var btnStatus = -1
    private val FILTER_CODE = 100

    private var screen: Screen? = null
    private var screenFour: ScreenFour? = null

    internal var screenBOListOne: List<ScreenBO>? = null
    internal var screenBOListTwo: List<ScreenBO>? = null
    internal var screenBOListThree: List<ScreenBO>? = null


    internal lateinit var container: FrameLayout

    companion object {
        private const val ID_HOME = 1
        private const val ID_EXPLORE = 2
        private const val ID_MESSAGE = 3
        private const val ID_NOTIFICATION = 4
        private const val ID_ACCOUNT = 5
    }

//    @SuppressLint("NewApi")
//    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
//    override fun attachBaseContext(newBase: Context?) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            super.attachBaseContext(MyContextWrapper.wrap(newBase, "fa"))
//        } else {
//            super.attachBaseContext(newBase)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screen = Screen(this)
        screenFour = ScreenFour(this)

        container = findViewById(R.id.container) as FrameLayout

//        tv_selected.typeface = Typeface.createFromAsset(assets, "fonts/SourceSansPro-Regular.ttf")

        bottomNavigation.add(MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_EXPLORE, R.drawable.ic_explore))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_MESSAGE, R.drawable.ic_message))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_notification))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_account))

//        bottomNavigation.setCount(ID_NOTIFICATION, "115")

        bottomNavigation.setOnShowListener {
            val name = when (it.id) {
                ID_HOME -> "HOME"
                ID_EXPLORE -> "EXPLORE"
                ID_MESSAGE -> "MESSAGE"
                ID_NOTIFICATION -> "NOTIFICATION"
                ID_ACCOUNT -> "ACCOUNT"
                else -> "MESSAGE"
            }
            if(it.id == ID_HOME){
                clickScreenOne(v = null)
            }else if(it.id == ID_EXPLORE){
                clickScreenTwo(v = null)
            }else if(it.id == ID_MESSAGE){
                clickScreenThree(v = null)
            }else if(it.id == ID_NOTIFICATION){
                clickScreenTwo(v = null)
            }else if(it.id == ID_ACCOUNT){
                clickScreenOne(v = null)
            }
        }

        bottomNavigation.setOnClickMenuListener {
            val name = when (it.id) {
                ID_HOME -> "HOME"
                ID_EXPLORE -> "EXPLORE"
                ID_MESSAGE -> "MESSAGE"
                ID_NOTIFICATION -> "NOTIFICATION"
                ID_ACCOUNT -> "ACCOUNT"
                else -> "MESSAGE"
            }
//            Toast.makeText(this, "$name is clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clickScreenOne(v: View?) {
        screen?.setView(container)
        btnStatus = SCREEN_ONE_STATUS
        screenBOListOne = ScreenOneGenerator.screenOneBOList()

        if (screenBOListOne != null && screenBOListOne!!.size > 0) {
            screen?.setData(screenBOListOne)
        } else {
            screen?.setData(ArrayList<ScreenBO>())
        }
    }

    fun clickScreenTwo(v: View?) {
        screen?.setView(container)
        btnStatus = SCREEN_TWO_STATUS
        screenBOListTwo = ScreenTwoGenerator.screenTwoBOList()
        if (screenBOListTwo != null && screenBOListTwo!!.size > 0) {
            screen?.setData(screenBOListTwo)
        } else {
            screen?.setData(ArrayList<ScreenBO>())
        }
    }

    private fun clickScreenThree(v: View?) {
        screen?.setView(container)
        btnStatus = SCREEN_THREE_STATUS
        screenBOListThree = ScreenThreeGenerator.screenThreeBOList()

        if (screenBOListThree != null && screenBOListThree!!.size > 0) {
            screen?.setData(screenBOListThree)
        } else {
            screen?.setData(ArrayList<ScreenBO>())
        }
    }

    private fun clickScreenFour(v: View?) {
        screenFour?.setView(container)
        btnStatus = SCREEN_FOUR_STATUS
        screenFour?.setData()
    }
}
