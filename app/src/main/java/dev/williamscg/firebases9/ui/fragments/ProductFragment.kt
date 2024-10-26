package dev.williamscg.firebases9.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import dev.williamscg.firebases9.R
import dev.williamscg.firebases9.adapter.ProductAdapter
import dev.williamscg.firebases9.model.ProductModel


class ProductFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_product, container, false)
        val db = FirebaseFirestore.getInstance()
        val rvProduct = view.findViewById<RecyclerView>(R.id.rvProduct)
        var lstProducts: List<ProductModel>

        db.collection("products")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    Log.e("Firestore Error", error.message.toString())
                    return@addSnapshotListener
                }
                lstProducts = value!!.documents.map { document ->
                    ProductModel(
                        document["name"].toString(),
                        document["stock"].toString(),
                        document["price"].toString(),
                        document["imageUrl"].toString()
                    )
                }
                rvProduct.adapter = ProductAdapter(lstProducts)
                rvProduct.layoutManager = LinearLayoutManager(requireContext())
            }
        return view
    }
}




