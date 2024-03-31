package kz.android.androidlab2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kz.android.androidlab2.adapters.CelebrityAdapter
import kz.android.androidlab2.api.RetrofitModule
import kz.android.androidlab2.databinding.ActivityMainBinding
import kz.android.androidlab2.models.Celebrity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val celebrityAdapter = CelebrityAdapter()


        binding.celebrityList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = celebrityAdapter
        }

        binding.search.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                RetrofitModule.apiService.getCelebritiesByName(v.text.toString()).enqueue(object :
                    Callback<List<Celebrity>> {
                    override fun onResponse(call: Call<List<Celebrity>>, response: Response<List<Celebrity>>) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                celebrityAdapter.submitList(it)
                            }
                        } else {
                            Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<List<Celebrity>>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Network Error", Toast.LENGTH_SHORT).show()
                    }
                })
                true
            } else false
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}