package com.example.jsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fetchURL="https://mysafeinfo.com/api/data?list=collegedegrees&format=json&case=default"
        val queue = Volley.newRequestQueue(this);
        val arrayList =ArrayList<JsonDataModel>()
        val fetchRequest=StringRequest(Request.Method.GET,fetchURL,
            Response.Listener<String>{response ->
                val str=response.toString()
                //txtdata.setText(str)
              Log.d("RESPONSE",response.toString())
             // val jsonObject:JSONObject=JSONObject(str)
                val jsonArray:JSONArray= JSONArray(str)



                for(i in 0 until jsonArray.length())
                {
                    var json_objectdetail:JSONObject=jsonArray.getJSONObject(i)
                    var model:JsonDataModel= JsonDataModel(json_objectdetail.getString("ID"),json_objectdetail.getString("Name"),json_objectdetail.getString("Degree"));

                    arrayList.add(model)
                }
                var resdata:StringBuilder=StringBuilder()

                for(i in 0 until arrayList.size)
                {
                    var strdata=arrayList.get(i)
                    resdata.append(strdata)
                }
                txtdata.setText(resdata)



        },
            Response.ErrorListener {  }

            )

        queue.add(fetchRequest)

        val obj_adapter : CustomListView
        obj_adapter = CustomListView(applicationContext,arrayList)
        listView.adapter=obj_adapter
    }


}
