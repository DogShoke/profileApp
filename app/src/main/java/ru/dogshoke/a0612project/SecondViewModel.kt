package ru.dogshoke.a0612project

import android.content.Intent
import android.net.Uri

import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.dogshoke.a0612project.databinding.ActivityMainBinding
import ru.dogshoke.a0612project.databinding.SecondActivityBinding

class SecondViewModel : ViewModel(){
    var activity : AppCompatActivity? = null
    var binding : SecondActivityBinding? = null
    var launcher: ActivityResultLauncher<Intent>? = null
    fun initBase(activity :AppCompatActivity, binding: SecondActivityBinding) {
        this.activity = activity
        this.binding = binding
        launcher = activity?.registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {
                val uriImage = it.data?.data
                val imageView: ImageView? = binding?.image!!
                imageView?.setImageURI(uriImage)
            }
        )
    }

    fun clickNumber(){
        val uri = Uri.parse("tel:88005553535")
        val intent = Intent(Intent.ACTION_DIAL,uri)
        activity?.startActivity(intent)
    }

    fun chooseImage(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        launcher?.launch(intent)
    }

    fun clickEmail(){
        val addresses = arrayOf("mail@mail.ru","mail2@yandex.ru")
        var uri = Uri.parse("mailto:")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra(Intent.EXTRA_EMAIL,addresses)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Заголовок Письма")
        intent.putExtra(Intent.EXTRA_TEXT, "Тело Письма")
        activity?.startActivity(intent)
    }

}