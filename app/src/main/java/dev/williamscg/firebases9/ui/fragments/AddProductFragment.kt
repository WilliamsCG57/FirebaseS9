package dev.williamscg.firebases9.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dev.williamscg.firebases9.R
import dev.williamscg.firebases9.model.ProductApiModel

class AddProductFragment : Fragment() {

    private val productApiViewModel: ProductApiViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_add_product, container, false)

        val etDescripcion: EditText = view.findViewById(R.id.etDescripcion)
        val etImageURL: EditText = view.findViewById(R.id.etImageURL)
        val etStock: EditText = view.findViewById(R.id.etStock)
        val etPrecio: EditText = view.findViewById(R.id.etPrecio)
        val etDescuento: EditText = view.findViewById(R.id.etDescuento)
        val btAgregarProducto: Button = view.findViewById(R.id.btAgregarProducto)

        btAgregarProducto.setOnClickListener {
            val descripcion = etDescripcion.text.toString()
            val imageUrl = etImageURL.text.toString()
            val stock = etStock.text.toString().toInt()
            val precio = etPrecio.text.toString().toDouble()
            val descuento = etDescuento.text.toString().toDouble()

            //Create ProductApiModel object
            val producto = ProductApiModel(
                description = descripcion,
                imageUrl = imageUrl,
                stock = stock,
                price = precio,
                discount = descuento,
                categoryId = 1
            )

            productApiViewModel.createProduct(producto)
            findNavController().navigate(R.id.nav_product_api)

        }
        return view

    }
}


