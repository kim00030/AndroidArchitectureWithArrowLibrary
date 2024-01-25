package com.dan.androidarchitercturewitharrowframework.store.presentation.util.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String) {

    TopAppBar(
        title = {
            Text(text = title)
        },
        modifier = Modifier.shadow(5.dp)
    )
}

@Composable
@Preview(showBackground = true)
fun MyTopAppBarPreview() {
    MyTopAppBar(title = "My Title")
}