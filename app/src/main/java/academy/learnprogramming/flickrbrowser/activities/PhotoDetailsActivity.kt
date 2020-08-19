package academy.learnprogramming.flickrbrowser.activities

import academy.learnprogramming.flickrbrowser.utils.BaseActivity
import academy.learnprogramming.flickrbrowser.utils.PHOTO_TRANSFER
import academy.learnprogramming.flickrbrowser.data.Photo
import academy.learnprogramming.flickrbrowser.R
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_photo_details.*

class PhotoDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)

        activateToolbar(true)

        //val photo = intent.getSerializableExtra(PHOTO_TRANSFER) as Photo
        val photo = intent.extras?.getParcelable<Photo>(PHOTO_TRANSFER) as Photo
        photo_title.text = resources.getString(R.string.photo_title_text, photo.title)
        photo_tags.text = resources.getString(R.string.photo_tags_text, photo.tags)
        val author = "Author: " + photo.author.substringAfter('\"').substringBefore('\"')

        photo_author.text = author

        Picasso.with(this).load(photo.image)
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(photo_image)

    }

}
