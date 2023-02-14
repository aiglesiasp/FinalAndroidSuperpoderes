package com.aiglesiaspubill.finalandroidsuperpoderes


import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.Thumbnail
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail.SetHero
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail.SetImage
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail.SetName
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun checkAllItems() {
        //GIVEN
        composeRule.setContent {
            //SetName("Goku")
            SetHero(listOf(Hero(0, "", "", Thumbnail("", ""))))
        }

        //WHEN
        //composeRule.onNodeWithText("VACIA").assertExists()

        //THEN
        composeRule.onNodeWithText("Goku").assertExists()
        //composeRule.onNodeWithText("VACIA").assertExists()
        //composeRule.onNodeWithText("").assertExists()
    }
}