package com.kotlin.multiplatform.core.presentation.viewstore

import com.kotlin.multiplatform.core.presentation.BaseViewModel
import com.kotlin.multiplatform.core.presentation.BaseViewState

abstract class BaseViewStore<
    ViewState : BaseViewState,
    ViewModel : BaseViewModel,
    ViewContract : com.kotlin.multiplatform.core.presentation.viewcontract.ViewContract<ViewModel>>(
    initialViewModel: ViewModel
) {
    protected lateinit var viewContract: ViewContract
        private set

    protected var viewModel = initialViewModel
        private set

    fun bind(viewContract: ViewContract) {
        this.viewContract = viewContract
    }

    protected fun render(viewModel: ViewModel) {
        this.viewModel = viewModel
        viewContract.render(viewModel)
    }
}
