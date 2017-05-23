package `in`.creativelizard.recyclerviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var myAdapter: MyAdapter? = null
    private var arrayList: ArrayList<MyItem>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
        setupList()
        loaddata()
    }

    private fun loaddata() {

        for (i in 0..9) {
            val myItem = MyItem()

            myItem.name = "Sid_" + i
            myItem.number = "098899876" + i
            arrayList!!.add(myItem)
        }

        myAdapter!!.notifyDataSetChanged()

    }

    private fun setupList() {
        rlItems!!.layoutManager = layoutManager
        rlItems!!.adapter = myAdapter
    }

    private fun initialize() {
       // rlItems = findViewById(R.id.rlItems) as RecyclerView
        arrayList = ArrayList<MyItem>()
        layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        myAdapter = MyAdapter(arrayList!!, this, R.layout.item_cell)

    }
}
