package com.example.deezertest.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun SearchBarSection(onValueChanged: ((String) -> Unit)) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchInputField(onValueChanged = { onValueChanged(it) })
    }
}

@Composable
fun SearchInputField(onValueChanged: ((String) -> Unit)) {
    val focusManager = LocalFocusManager.current
    var state by remember { mutableStateOf(TextFieldValue("")) }


    Surface(
        elevation = 3.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        BasicTextField(
            value = state,
            onValueChange = {
                state = it
                onValueChanged(it.text)
            },
            singleLine = true,
            maxLines = 1,
            modifier = Modifier
                .background(MaterialTheme.colors.surface, RoundedCornerShape(8.dp))
                .height(45.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(MaterialTheme.colors.onSurface, fontWeight = FontWeight.Bold),
            cursorBrush = SolidColor(MaterialTheme.colors.onSurface),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            decorationBox = { innerTextField ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search icon",
                        tint = MaterialTheme.colors.primary
                    )
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (state.text.isEmpty())
                            Text(
                                text = "artist name ...",
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier.alpha(0.4f)
                            )
                        innerTextField()
                    }

                    if (state.text.isNotBlank()) {
                        IconButton(onClick = { state = TextFieldValue("") }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "reset search bar",
                                tint = MaterialTheme.colors.primary
                            )
                        }
                    }
                }
            }
        )
    }
}