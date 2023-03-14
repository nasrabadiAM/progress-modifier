# Progress Modifier for jetpack compose
This is a modifier for drawing a progress over your Composable views.

![](./docs/resources/dark-theme.gif | width=240)
![](./docs/resources/light-theme.gif | width=240)

To use this progress modifier on your views you can do it this way:
```kotlin 

    Box(
        Modifier
            //..... other modifiers 
            .progressAnimation(durationMillis = 10_000)
    )

```

you should pass a duration which is a the duration for your progress. then it shows a progress animation on your view till it finished.


If you want to be notified when animation finished, you can add callback to it.
```kotlin 

    Box(
        Modifier
            //..... other modifiers 
            .progressAnimation(durationMillis = 10_000, finishedListener = {
                Log.d("ProgressModifer", "animation finished!")
            })
    )
```

As the [order of modifiers matters](https://developer.android.com/jetpack/compose/modifiers#order-modifier-matters), you should add it, after your bakground and clip modifier. 

