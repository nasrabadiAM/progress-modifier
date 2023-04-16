# Progress Modifier for jetpack compose

This is a modifier for drawing a progress over your Composable views.


<img src="https://user-images.githubusercontent.com/31126059/224983077-3464497b-d27b-4c4a-8946-c9e0a0faf3a1.gif"  width="240"> <img src="https://user-images.githubusercontent.com/31126059/224983088-39ded85a-53bc-4bc2-bc39-e74739b260d0.gif"  width="240">

### Add library

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Then add the dependency:

```groovy
dependencies {
    implementation "com.github.nasrabadiam:progress-modifier:1.0.0"
}
```


### Usage
To use this progress modifier on your views you can do it this way:

```kotlin 

    Box(
        Modifier
            //..... other modifiers 
            .progressAnimation(durationMillis = 10_000)
    )

```

you should pass a duration which is a the duration for your progress. then it shows a progress
animation on your view till it finished.

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

Or if you have a percent value and wanna update progress animation with percent value, do it like
this:

```kotlin
    Box(
    Modifier
        //..... other modifiers 
        .progress(percent = percent) //percent is a float range between 0f to 100f
)
```

As
the [order of modifiers matters](https://developer.android.com/jetpack/compose/modifiers#order-modifier-matters)
, you should always add it after your background and clip modifier.

### Blog Post 📝

There is a series of blog posts about modifiers and creating custom modifiers
available [here](https://medium.com/@nasrabadiam/an-introduction-to-create-custom-modifiers-in-jetpack-compose-part-1-modifiers-basics-9868d315d3dc)
. In the third part of the series, I will discuss this project in more detail and provide additional
information about its implementation.

### Disclaimer ⚠️

Note: using this modifier on `buttons` will not work as they add their shape at the end of surface
modifiers.

### contribution 🛠️

If you have any ideas that could be applied to buttons or any other ideas, I would appreciate
hearing them. Additionally, if you would like to contribute to the development of new features or
..., your contributions are welcome and greatly appreciated.
