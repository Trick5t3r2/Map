package com.trick5t3r.map

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trick5t3r.map.models.DisplayMapActivity
import com.trick5t3r.map.models.MapsAdapter
import com.trick5t3r.map.models.Place
import com.trick5t3r.map.models.UserMap

const val EXTRA_USER_MAP = "EXTRA_USER_MAP"
private const val Tag="MainActivity"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userMaps = generateSampleData()
        //Set layout manager on the recycle view
        val tdMaps:RecyclerView=findViewById(R.id.tdMaps)
        tdMaps.layoutManager = LinearLayoutManager(this)
        //Set adapter on the recycle view)
        tdMaps.adapter = MapsAdapter(this, userMaps, object: MapsAdapter.OnClickListener{
            override fun onItemClick(position: Int) {
                Log.i(Tag,"OnItemClick $position")
                //When user taps on view in RV, navigation to new activity
                val intent = Intent(this@MainActivity,DisplayMapActivity::class.java)
                intent.putExtra(EXTRA_USER_MAP, userMaps[position])
                startActivity(intent)
            }
        })

    }

    private fun generateSampleData(): List<UserMap> {
        return listOf(
            UserMap(
                "Universitites Of Sri Lanka",
                listOf(
                    Place("University Of Kelaniya", "University Of Kelaniya", 6.974285554266355, 79.91578690500513),
                    Place("University Of Colombo", "University Of Colombo", 6.9011651390426465, 79.85864635017865),
                    Place("University Of Moratuwa", "University Of Moratuwa", 6.7963207091771585, 79.90073820680335),
                    Place("University Of Peradeniya", "University Of Peradeniya", 7.25560872660696, 80.59734345061348),
                    Place("University Of Jaffna", "University Of Jaffna", 9.685532348344577, 80.0219983378257),
                    Place("University Of Sri Jayewardenepura", "University Of Sri Jayewardenepura", 6.85349126948605, 79.90349872215013),
                    Place("University Of Ruhuna", "University Of Ruhuna", 5.9391164722565355, 80.57600560672532),
                    Place("University Of Vavuniya", "University Of Vavuniya", 8.759124780715897, 80.41064228339211),
                    Place("Eastern University", "Eastern University", 7.795790636845408, 81.57898356102375),
                    Place("Rajarata University", "Rajarata University", 8.362978521659473, 80.50471852231416),
                    Place("Sabaragamuwa University", "Sabaragamuwa University", 6.715614025227969, 80.78726136816019),
                    Place("South Eastern University", "South Eastern University", 7.297733935515577, 81.84990400685392),
                    Place("Wayamba University", "Wayamba University", 7.467647840778933, 80.02112403225217),
                    Place("Uva Wellassa University", "Uva Wellassa University", 6.982608311361615, 81.07629421420987),
                    Place("University Of the Visual and Performing Arts", "University Of the Visual and Performing Arts", 6.910940102872361, 79.86241282215576),
                    Place("Open University", "Open University", 6.885587285191926, 79.88400168351787),
                )
            ),
        )
    }}