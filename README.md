# Art Space
#### Video Demo: 
https://youtu.be/_3KOmXnUeNg
#### Description:
During the official Android tutorials, a [challenge](https://developer.android.com/codelabs/basic-android-kotlin-compose-art-space?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-art-space#0) was presented to display artwork and give credit to the artist. The name of the app is Art Space. The tutorial gave an example of what the app could look like, which I followed closely and came up with my own solution. The app displays a piece of art at the top and gives the title, artist and year below. At the very bottom are buttons to go forward and backward, looping around as needed to create a continuous flow allowing the user to easily see all the artwork.

The app is written in Kotlin with Compose, representing the current state of Android development. The application skeleton was generated within Android Studio by creating an "Empty Compose Activity". 

The majority of the code lies in the MainActivity.kt file. Our top level composable is the ArtSpaceApp. It does several things:
- Holds all artwork and current artwork state (artIndex) that we need to keep track of during [recomposition](https://developer.android.com/jetpack/compose/lifecycle#lifecycle-overview). 
- Ensures the app takes up the full screen.
- Arranges items vertically by using a [Column](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#column) composable.
- Consumes other composables to create the UI: `Artwork`, `ArtworkInfo`, `ActionButtons`.
- Contains logic to move to the next or previous artwork.

The `Artwork` composable takes in an image and description (for screen readers). It utilizes out-of-box [Surface](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#surface) and [Image](https://developer.android.com/jetpack/compose/graphics/images/loading) composables. We draw a border around the Surface to call more attention to the artwork.

The `ArtworkInfo` composable takes in the image details: title, artist and year. It uses the out-of-box [Text](https://developer.android.com/jetpack/compose/text) composable to place and format the information in a visually pleasing manner.

The `ActionButtons` composable takes in a lambda function on what the Previous and Next buttons should do. I used the out-of-box [Button](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#Button(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.foundation.interaction.MutableInteractionSource,androidx.compose.material.ButtonElevation,androidx.compose.ui.graphics.Shape,androidx.compose.foundation.BorderStroke,androidx.compose.material.ButtonColors,androidx.compose.foundation.layout.PaddingValues,kotlin.Function1)) composable.

In addition to the code in MainActivity, I imported 5 images as a [resource](https://developer.android.com/guide/topics/resources/providing-resources) and created all strings (like artist name) as a resource as well so the application can be localized. There is also a `ArtworkData` class that specifies artwork fields as well as provides the actual data as a list.

There is more that could have been done with this app such as obtaining the artwork through some API instead of keeping all images and data internal to the application. This would allow the gallery to grow much larger than the 5 curated paintings that currently ships with the app.