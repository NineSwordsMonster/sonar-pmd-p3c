/*
 * SonarQube PMD P3C Plugin
 * Copyright (C) 2012-2020 NineSwordsMonster
*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.pmd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PmdConstantsTest {

    @Test
    void checkDefinedKeys() {
        assertThat(PmdConstants.PLUGIN_NAME).isEqualTo("PMD-P3C");
        assertThat(PmdConstants.PLUGIN_KEY).isEqualTo("pmd-p3c");
        assertThat(PmdConstants.REPOSITORY_KEY).isEqualTo("pmd-p3c");
        assertThat(PmdConstants.REPOSITORY_NAME).isEqualTo("PMD-P3C");
        assertThat(PmdConstants.TEST_REPOSITORY_KEY).isEqualTo("pmd-p3c-unit-tests");
        assertThat(PmdConstants.TEST_REPOSITORY_NAME).isEqualTo("PMD P3C Unit Tests");
        assertThat(PmdConstants.XPATH_CLASS).isEqualTo("net.sourceforge.pmd.lang.rule.XPathRule");
        assertThat(PmdConstants.XPATH_EXPRESSION_PARAM).isEqualTo("xpath");
        assertThat(PmdConstants.XPATH_MESSAGE_PARAM).isEqualTo("message");
        assertThat(PmdConstants.JAVA_SOURCE_VERSION).isEqualTo("sonar.java.source");
        assertThat(PmdConstants.JAVA_SOURCE_VERSION_DEFAULT_VALUE).isEqualTo("1.6");
        assertThat(PmdConstants.LANGUAGE_KEY).isEqualTo("java");
    }
}
