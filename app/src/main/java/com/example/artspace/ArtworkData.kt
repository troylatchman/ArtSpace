package com.example.artspace

data class ArtworkData(val image: Int, val title: Int, val artist: Int, val year: Int) {

/*
1. Mona Lisa | 1503-1506 | Leonardo da Vinci
2. The Creation of Adam | 1508-1512 | 	Michelangelo
3. Girl with a Pearl Earring | 1665 | 	Johannes Vermeer
4. The Starry Night | 1889 | 	Vincent van Gogh
5. American Gothic | 1930 | Grant Wood
 */

    companion object {
        fun getAllArtwork(): List<ArtworkData> {
            return listOf<ArtworkData>(
                ArtworkData(
                    R.drawable.mona_lisa,
                    R.string.mona_lisa_title,
                    R.string.mona_lisa_artist,
                    R.string.mona_lisa_year
                ),
                ArtworkData(
                    R.drawable.the_creation_of_adam,
                    R.string.the_creation_of_adam_title,
                    R.string.the_creation_of_adam_artist,
                    R.string.the_creation_of_adam_year
                ),
                ArtworkData(
                    R.drawable.girl_with_a_pearl_earring,
                    R.string.girl_with_a_pearl_earring_title,
                    R.string.girl_with_a_pearl_earring_artist,
                    R.string.girl_with_a_pearl_earring_year
                ),
                ArtworkData(
                    R.drawable.the_starry_night,
                    R.string.the_starry_night_title,
                    R.string.the_starry_night_artist,
                    R.string.the_starry_night_year
                ),
                ArtworkData(
                    R.drawable.american_gothic,
                    R.string.american_gothic_title,
                    R.string.american_gothic_artist,
                    R.string.american_gothic_year
                )
            )
        }
    }
}