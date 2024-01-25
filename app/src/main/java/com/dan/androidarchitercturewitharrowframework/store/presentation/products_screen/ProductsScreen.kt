package com.dan.androidarchitercturewitharrowframework.store.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dan.androidarchitercturewitharrowframework.R
import com.dan.androidarchitercturewitharrowframework.store.presentation.util.components.LoadingDialog
import com.dan.androidarchitercturewitharrowframework.store.presentation.util.components.MyTopAppBar

@Composable
internal fun ProductsScreen(productViewModel: ProductsViewModel = hiltViewModel()) {

    val state by productViewModel.state.collectAsStateWithLifecycle()
    //val state by productViewModel.composeState
    ProductsContent(productViewState = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsContent(productViewState: ProductsViewState) {

    LoadingDialog(isLoading = productViewState.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(title = stringResource(R.string.products))
        }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(productViewState.products) { product ->


            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProductsContentPreview() {
    ProductsContent(productViewState = ProductsViewState(isLoading = true))
}