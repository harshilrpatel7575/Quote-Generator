package com.example.vollyapi

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.vollyapi.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    val url: String ="https://api.quotable.io/quotes/random"
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMemeData()

        binding.btnNewMeme.setOnClickListener{
            getMemeData()
        }

        binding.btnCopy.setOnClickListener {
            copyToClipboard(binding.memeTitle.text.toString())
            Toast.makeText(this@MainActivity, "Quote copied to clipboard", Toast.LENGTH_SHORT).show()
        }

    }

    private fun getMemeData() {
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                 Log.e("Responce", "getMemeData: " + response.toString())
                 var jsonArray = JSONArray(response)
                if (jsonArray.length() > 0) {
                    val responseObject = jsonArray.getJSONObject(0)

                    val content = responseObject.getString("content")
                    val author = responseObject.getString("author")



                    binding.memeTitle.text = content
                    binding.memeAuther.text = author


                } else {
                    Toast.makeText(this@MainActivity, "No data found", Toast.LENGTH_SHORT).show()
                }

            },
            {
                error->

                Toast.makeText(this@MainActivity, error.localizedMessage,Toast.LENGTH_SHORT).show()
            })


        queue.add(stringRequest)
    }

    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Quote", text)
        clipboard.setPrimaryClip(clip)
    }

}