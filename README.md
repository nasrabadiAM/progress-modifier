# Progress Modifier for jetpack compose
This is a modifier for drawing a progress over your Composable views.

<video width="240" controls>
  <source src="./docs/resources/dark-theme.mp4" type="video/mp4">
</video> 
<video width="240" controls>
  <source src="./docs/resources/light-theme.mp4" type="video/mp4">
</video> 


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

