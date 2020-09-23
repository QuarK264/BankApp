package com.bank.app.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.bank.app.core.base.BaseViewModel
import com.bank.app.core.domain.interaction.GetSimpleUsersInteractor
import com.bank.app.core.domain.interaction.GetUserInteractor
import com.bank.app.core.extension.execute
import com.bank.app.ui.details.model.User
import com.bank.app.ui.details.model.mapToView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import org.kodein.di.generic.instance

class BankViewModel(application: Application) : BaseViewModel(application) {

    private val getUserInteractor: GetUserInteractor by instance()
    private val getSimpleUsersInteractor: GetSimpleUsersInteractor by instance()

    private val disposable = CompositeDisposable()
    private var user: User? = null

    var response = MutableLiveData<UserResponse>()

    fun getUser() {
        val user = user
        val singleUser = if (user != null) {
            getUserInteractor.execute(user.cardNumber)
        } else {
            getSimpleUsersInteractor.execute().flatMap {
                getUserInteractor.execute(it.first().cardNumber)
            }
        }

        singleUser
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { response.value = UserResponse.loading() }
            .subscribe(
                {
                    this.user = it.mapToView()
                    response.value = UserResponse.success(it.mapToView())
                },
                {
                    response.value = UserResponse.error(it)
                }
            )
            .addTo(disposable)
    }

    override fun onCleared() {
        disposable.clear()
    }
}