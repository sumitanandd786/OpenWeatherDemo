package com.openweatherdemo.ui.splash

import android.graphics.Color
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.openweatherdemo.core.BaseFragment
import com.openweatherdemo.core.Constants
import com.openweatherdemo.databinding.FragmentSplashBinding
import com.openweatherdemo.ui.splash.SplashFragmentViewModel
import com.openweatherdemo.utils.extensions.hide
import com.openweatherdemo.utils.extensions.show
import com.mikhaellopez.rxanimation.*
import com.mikhaellopez.rxanimation.RxAnimation.sequentially
import com.mikhaellopez.rxanimation.RxAnimation.together
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.processNextEventInCurrentThread

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashFragmentViewModel, FragmentSplashBinding>(
    com.openweatherdemo.R.layout.fragment_splash,
    SplashFragmentViewModel::class.java,
) {
    var disposable = CompositeDisposable()

    override fun init() {
        super.init()

        if (binding.viewModel?.sharedPreferences?.getString(Constants.Coords.LON, "")
                .isNullOrEmpty()
        ) {
            binding.buttonExplore.show()
            binding.viewModel?.navigateDashboard = false
        } else {
            binding.buttonExplore.hide()
            binding.viewModel?.navigateDashboard = true
        }

        binding.viewModel?.navigateDashboard?.let { startSplashAnimation(it) }

        binding.buttonExplore.setOnClickListener {
            binding.viewModel?.navigateDashboard?.let { it1 -> endSplashAnimation(it1) }
        }

        binding.rootView.setOnClickListener {
            binding.viewModel?.navigateDashboard?.let { it1 -> endSplashAnimation(it1) }
        }
    }


    private fun startSplashAnimation(navigateToDashboard: Boolean) {
        disposable.add(
            Observable.fromCallable {
                findNavController().graph.setStartDestination(com.openweatherdemo.R.id.dashboardFragment) // Little bit tricky solution :)
                if (navigateToDashboard) {
                    endSplashAnimation(navigateToDashboard)
                }
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
            //  RxAnimation.sequentially(
            /*together(
                binding.imageViewBottomDrawable.translationY(500f),
                binding.imageViewEllipse.fadeOut(0L),
                binding.imageViewBottomDrawable.fadeOut(0L),
                binding.imageViewBigCloud.translationX(-500F, 0L),
                binding.imageViewSmallCloud.translationX(500f, 0L),
                binding.imageViewBottomDrawableShadow.translationY(500f),
                binding.imageViewMainCloud.fadeOut(0L),
                binding.buttonExplore.fadeOut(0L),
                binding.imageViewBottomDrawableShadow.fadeOut(0L)
            ), together(
                binding.imageViewBottomDrawable.fadeIn(1000L),
                binding.imageViewBottomDrawable.translationY(-1f),
                binding.imageViewBottomDrawableShadow.fadeIn(1250L),
                binding.imageViewBottomDrawableShadow.translationY(-1f)
            ), together(
                binding.imageViewEllipse.fadeIn(1000L),
                binding.imageViewEllipse.translationY(-50F, 1000L)
            ), together(
                binding.imageViewBigCloud.translationX(-15f, 1000L),
                binding.imageViewSmallCloud.translationX(25f, 1000L)
            ), */
            // binding.imageViewMainCloud.fadeIn(500L), binding.buttonExplore.fadeIn(1000L)

            /*).doOnTerminate {
                findNavController().graph.setStartDestination(com.openweatherdemo.R.id.dashboardFragment) // Little bit tricky solution :)
                if (navigateToDashboard) {
                    endSplashAnimation(navigateToDashboard)
                }
            }.subscribe()*/
        )
    }

    private fun endSplashAnimation(navigateToDashboard: Boolean) {
        disposable.add(
            Observable.fromCallable {
                findNavController().graph.setStartDestination(com.openweatherdemo.R.id.dashboardFragment) // Little bit tricky solution :)
                if (navigateToDashboard) {
                    navigate(com.openweatherdemo.R.id.action_splashFragment_to_dashboardFragment)
                } else {
                    navigate(com.openweatherdemo.R.id.action_splashFragment_to_searchFragment)
                }
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
            /*sequentially(
                together(
                    binding.imageViewBottomDrawable.fadeOut(300L),
                    binding.imageViewBottomDrawable.translationY(100f),
                    binding.imageViewBottomDrawableShadow.fadeOut(300L),
                    binding.imageViewBottomDrawableShadow.translationY(100f)
                ),

                together(
                    binding.imageViewEllipse.fadeOut(300L),
                    binding.imageViewEllipse.translationY(500F, 300L)
                ),

                together(
                    binding.imageViewBigCloud.translationX(500f, 300L),
                    binding.imageViewSmallCloud.translationX(-500f, 300L)
                ),

                binding.imageViewMainCloud.fadeOut(300L),
                binding.buttonExplore.fadeOut(300L),
                binding.rootView.backgroundColor(
                    Color.parseColor("#5D50FE"), Color.parseColor("#FFFFFF"), duration = 750L
                )
            ).doOnTerminate {
                findNavController().graph.setStartDestination(com.openweatherdemo.R.id.dashboardFragment) // Little bit tricky solution :)
                if (navigateToDashboard) {
                    navigate(com.openweatherdemo.R.id.action_splashFragment_to_dashboardFragment)
                } else {
                    navigate(com.openweatherdemo.R.id.action_splashFragment_to_searchFragment)
                }
            }.subscribe()*/

        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }

}


