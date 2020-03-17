package com.example.startup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var adapter: FoodAdapter?=null
    var ListOfFoods = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ListOfFoods.add(Food("CoffeePot","A coffee pot is a tall narrow pot with a spout and a lid, in which coffee is made or served.",R.drawable.coffee_pot))

        ListOfFoods.add(Food("Espresso", "Espresso is a full-flavored, concentrated form of coffee that is served in “shots.” It is made by forcing pressurized hot water through very finely ground coffee beans using an espresso machine.", R.drawable.espresso))

        ListOfFoods.add(Food("Fries", "French fries or simply fries or chips, are pieces of potato that have been deep-fried. ", R.drawable.french_fries))

        ListOfFoods.add(Food("Honey", "Honey is a sweet, viscous food substance made by bees and some related insects. ", R.drawable.honey))

        ListOfFoods.add(Food("Strawberry","A strawberry is both a low-growing, flowering plant and also the name of the fruit that it produces. ", R.drawable.strawberry_ice_cream))

        ListOfFoods.add(Food("SugarCubes", "Sugar cubes are small lumps of sugar shaped into cubes. You put them in cups of tea and coffee.", R.drawable.sugar_cubes))

        adapter = FoodAdapter(this, ListOfFoods)

        ListFood.adapter=adapter
    }

    class FoodAdapter: BaseAdapter{

        var ListOfFood = ArrayList<Food>()
        var context : Context?= null

        constructor(context: Context, ListOfFood:ArrayList<Food>):super(){
            this.ListOfFood = ListOfFood
            this.context= context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var food = ListOfFood[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView= inflator.inflate(R.layout.food_ticket,null)
            foodView.foodimage.setImageResource(food.image!!)
            foodView.foodimage.setOnClickListener {
                val intent = Intent(context, FoodDetail::class.java)
                intent.putExtra("name", food.name!!)
                intent.putExtra("des", food.des!!)
                intent.putExtra("image", food.image!!)
                context!!.startActivity(intent)
            }
            foodView.tvname.text(food.name!!)
            return  foodView

        }

        override fun getItem(position: Int): Any {
        return ListOfFood[position]
        }

        override fun getItemId(position: Int): Long {
             return position.toLong()
        }

        override fun getCount(): Int {
            return ListOfFood.size
        }

    }
}

private operator fun CharSequence.invoke(name: String) {

}

private fun Nothing?.inflate(foodTicket: Int, nothing: Nothing?): View {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
