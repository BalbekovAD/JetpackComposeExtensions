@file:Suppress("unused")

package ru.ad.balbekov.library.widgets.text

import androidx.annotation.StringRes
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

/**
 * High level element that displays text and provides semantics / accessibility information.
 *
 * The default [style] uses the [LocalTextStyle] provided by the [MaterialTheme] / components.
 * If
 * you are setting your own style, you may want to consider first retrieving [LocalTextStyle],
 * and using [TextStyle.copy] to keep any theme-defined attributes, only modifying the specific
 * attributes you want to override.
 *
 * For ease of use, commonly used parameters from [TextStyle] are also present here.
 * The order of
 * precedence is as follows:
 * - If a parameter is explicitly set here (i.e, it is _not_ `null` or [TextUnit.Unspecified]),
 * then this parameter will always be used.
 * - If a parameter is _not_ set, (`null` or [TextUnit.Unspecified]), then the corresponding value
 * from [style] will be used instead.
 *
 * Additionally, for [color], if [color] is not set, and [style] does not have a color, then
 * [LocalContentColor] will be used.
 *
 * @param text ID of the [StringRes] to be displayed
 * @param modifier the [Modifier] to be applied to this layout node
 * @param color [Color] to apply to the text.
 * If [Color.Unspecified], and [style] has no color set,
 * this will be [LocalContentColor].
 * @param fontSize the size of glyphs to use when painting the text. See [TextStyle.fontSize].
 * @param fontStyle the typeface variant to use when drawing the letters (e.g., italic).
 * See [TextStyle.fontStyle].
 * @param fontWeight the typeface thickness to use when painting the text (e.g., [FontWeight.Bold]).
 * @param fontFamily the font family to be used when rendering the text. See [TextStyle.fontFamily].
 * @param letterSpacing the amount of space to add between each letter.
 * See [TextStyle.letterSpacing].
 * @param textDecoration the decorations to paint on the text (e.g., an underline).
 * See [TextStyle.textDecoration].
 * @param textAlign the alignment of the text within the lines of the paragraph.
 * See [TextStyle.textAlign].
 * @param lineHeight line height for the [Paragraph] in [TextUnit] unit, e.g. SP or EM.
 * See [TextStyle.lineHeight].
 * @param overflow how visual overflow should be handled.
 * @param softWrap whether the text should break at soft line breaks.
 * If false, the glyphs in the
 * text will be positioned as if there was unlimited horizontal space.
 * If [softWrap] is false,
 * [overflow] and TextAlign may have unexpected effects.
 * @param maxLines an optional maximum number of lines for the text to span, wrapping if
 * necessary.
 * If the text exceeds the given number of lines, it will be truncated according to
 * [overflow] and [softWrap].
 * If it is not null, then it must be greater than zero.
 * @param onTextLayout callback that is executed when a new text layout is calculated.
 * A
 * [TextLayoutResult] object that callback provides contains paragraph information, size of the
 * text, baselines and other details.
 * The callback can be used to add additional decoration or
 * functionality to the text.
 * For example, to draw selection around the text.
 * @param style style configuration for the text such as color, font, line height etc.
 */
@Composable
fun Text(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) = Text(
    text = stringResource(text),
    modifier = modifier,
    color = color,
    fontSize = fontSize,
    fontStyle = fontStyle,
    fontWeight = fontWeight,
    fontFamily = fontFamily,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
    textAlign = textAlign,
    lineHeight = lineHeight,
    overflow = overflow,
    softWrap = softWrap,
    maxLines = maxLines,
    onTextLayout = onTextLayout,
    style = style
)