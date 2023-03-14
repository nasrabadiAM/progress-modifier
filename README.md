# Progress Modifier for jetpack compose
This is a modifier for drawing a progress over your Composable views.


<img src="https://user-images.githubusercontent.com/31126059/224983077-3464497b-d27b-4c4a-8946-c9e0a0faf3a1.gif"  width="240"> <img src="https://user-images.githubusercontent.com/31126059/224983088-39ded85a-53bc-4bc2-bc39-e74739b260d0.gif"  width="240">


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

As the [order of modifiers matters](https://developer.android.com/jetpack/compose/modifiers#order-modifier-matters), you should add it after your bakground and clip modifier. 

