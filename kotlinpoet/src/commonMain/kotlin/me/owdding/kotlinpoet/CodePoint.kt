/*
 * Copyright (C) 2024 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.owdding.kotlinpoet

import kotlin.jvm.JvmInline

@JvmInline
internal value class CodePoint(val code: Int)

internal expect fun String.codePointAt(index: Int): CodePoint

internal expect fun CodePoint.isLowerCase(): Boolean
internal expect fun CodePoint.isUpperCase(): Boolean

internal expect fun CodePoint.isJavaIdentifierStart(): Boolean
internal expect fun CodePoint.isJavaIdentifierPart(): Boolean

internal expect fun CodePoint.charCount(): Int

internal expect fun StringBuilder.appendCodePoint(codePoint: CodePoint): StringBuilder
