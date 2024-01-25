package com.dan.androidarchitercturewitharrowframework.store.presentation.products_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dan.androidarchitercturewitharrowframework.store.domain.model.Product
import com.dan.androidarchitercturewitharrowframework.store.domain.model.Rating

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = modifier.padding(15.dp)) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = modifier.height(5.dp))

            Text(text = product.title, style = MaterialTheme.typography.titleMedium)
        }

    }
}

@Composable
@Preview(showBackground = true)
fun ProductCardPreview() {
    ProductCard(
        product = Product(
            category = "men's clothing",
            description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            id = 1,
            image = "",
            price = 100.87,
            rating = Rating(count = 120, rate = 3.9),
            title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
        )
    )
}