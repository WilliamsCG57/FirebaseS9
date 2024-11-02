package dev.williamscg.firebases9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.williamscg.firebases9.R
import dev.williamscg.firebases9.model.ProductApiModel

class ProductApiAdapter(private var productList: List<ProductApiModel>) :
    RecyclerView.Adapter<ProductApiAdapter.ViewHolder>() {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val ivProductApi = itemView.findViewById<ImageView>(R.id.ivProductApi)
            val tvDescriptionProduct = itemView.findViewById<TextView>(R.id.tvDescriptionProduct)
            val tvPriceProduct = itemView.findViewById<TextView>(R.id.tvPriceProduct)
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_product_api, parent, false))
    }
    override fun getItemCount(): Int {
        return productList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemProducto = productList[position]
        holder.tvDescriptionProduct.text = itemProducto.description
        holder.tvPriceProduct.text = itemProducto.price.toString()
        //Load image with Glide
        Glide.with(holder.itemView.context)
            .load(itemProducto.imageUrl)
            .into(holder.ivProductApi)
    }
    fun updateProductList(newProductList: List<ProductApiModel>) {
        productList = newProductList
        notifyDataSetChanged()
    }
}