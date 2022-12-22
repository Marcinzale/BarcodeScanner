package marcin.example.barcodescanner

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build.VERSION_CODES.M
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.budiyev.android.codescanner.*
import kotlinx.android.synthetic.main.activity_main.*

private const val CAMERA_REQUEST_CODE = 101

class MainActivity : AppCompatActivity() {

    private lateinit var codeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPermissions()
        codeScanner()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun codeScanner() {
        codeScanner = CodeScanner(this, scanner_view)

        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS
            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false

            decodeCallback = DecodeCallback {
                runOnUiThread {
                    tv_text.text = it.text.toString()
                    val subText = tv_text.text.substring(0, 3)
                    val newText = subText.toIntOrNull()
                    flag.isVisible = true

                    when (newText) {
                        590 -> {
                            flag.setBackgroundResource(R.drawable.ic_polish_flag)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest POLSKA",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 100..139 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_the_united_states)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu są Stany Zjednoczone",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        208 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_taiwan)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Taiwan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 300..379 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_france)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Francja",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        380 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_bulgaria)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Bułgaria",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 400..440 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_germany)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu są Niemcy",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 450..459, in(490..499) ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_japan)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Japonia",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 460..469 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_russia)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest ROSJA",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        489 -> {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_hong_kong)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Hong Kong",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 500..509 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_the_united_kingdom)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Wielka Brytania",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        520 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_greece)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Grecja",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 690..699 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_china)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu są Chiny",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 700..709 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_norway)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Japonia",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        729 -> {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_israel)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Izrael",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 730..739 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_sweden)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Szwecja",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 760..769 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_switzerland)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Szwajcaria",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        780 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_chile)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Chile",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 800..839 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_italy)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu są Włochy",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        850 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_cuba)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Kuba",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        858 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_slovakia)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Słowacja",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        859 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_czech)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu są Czechy",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 868..869 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_turkey)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Turcja",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        880 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_south_korea)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Korea Południowa",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        885 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_thailand)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Tajlandia",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 870..879 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_the_netherlands)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Holandia",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        890 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_india)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu są Indie",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        893 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_vietnam)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Wietnam",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        896 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_pakistan)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Pakistan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        899 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_indonesia)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Indonezja",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 900..919 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_austria)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Austria",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 930..939 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_australia)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Australia",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 940..949 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_new_zealand)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Nowa Zelandia",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        955 ->  {
                            flag.setBackgroundResource(R.drawable.ic_flag_of_malaysia)
                            Toast.makeText(
                                applicationContext,
                                "Krajem pochodzenia tego produktu jest Malezja",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        977 ->  {
                            flag.isVisible = false
                            check.isVisible = true
                            check.setBackgroundResource(R.drawable.ic_library_books)
                            Toast.makeText(
                                applicationContext,
                                "ISSN - publikacje seryjne",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        in 978..979 ->  {
                            flag.isVisible = false
                            check.isVisible = true
                            check.setBackgroundResource(R.drawable.ic_book)
                            Toast.makeText(
                                applicationContext,
                                "ISBN - identyfikacja książek",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else -> {
                            flag.isVisible = false
                            check.isVisible = true
                            check.setBackgroundResource(R.drawable.ic_check)
                            Toast.makeText(applicationContext, "Produkt nieznanego pochodzenia",
                                Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
        scanner_view.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.CAMERA),
            CAMERA_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "You need the camera permission", Toast.LENGTH_SHORT)
                        .show()
                } else {
                }
            }
        }
    }
}