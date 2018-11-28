package tech.thdev.kotlin_udemy_sample.view.image

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.util.replaceFragmentToActivity

class ImageActivity : AppCompatActivity() {

    private val toolbar by lazy {
        findViewById(R.id.toolbar) as Toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_sample)

        toolbar.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        replaceFragmentToActivity(ImageCommunityFragment.getInstance(), R.id.frame_layout)
    }
}
