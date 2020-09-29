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

import com.google.common.collect.Iterables;
import org.junit.jupiter.api.Test;
import org.sonar.api.PropertyType;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.Param;
import org.sonar.api.server.rule.RulesDefinition.Rule;
import org.sonar.plugins.pmd.rule.PmdP3cRulesDefinition;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PmdP3cRulesDefinitionTest {

    @Test
    void test() {
        PmdP3cRulesDefinition definition = new PmdP3cRulesDefinition();
        RulesDefinition.Context context = new RulesDefinition.Context();
        definition.define(context);
        RulesDefinition.Repository pdmRepo = context.repository(PmdConstants.REPOSITORY_KEY);
        RulesDefinition.Repository p3cRepo = context.repository(PmdConstants.REPOSITORY_P3C_KEY);

        assertThat(pdmRepo.name()).isEqualTo(PmdConstants.REPOSITORY_NAME);
        assertThat(pdmRepo.language()).isEqualTo(PmdConstants.LANGUAGE_KEY);
        List<Rule> rules1 = pdmRepo.rules();
        assertThat(rules1).hasSize(268);
        for (Rule rule : rules1) {
            assertThat(rule.key()).isNotNull();
            assertThat(rule.internalKey()).isNotNull();
            assertThat(rule.name()).isNotNull();
            assertThat(rule.htmlDescription()).isNotNull();
            assertThat(rule.severity()).isNotNull();

            for (Param param : rule.params()) {
                assertThat(param.name()).isNotNull();
                assertThat(param.description())
                        .overridingErrorMessage("Description is not set for parameter '" + param.name() + "' of rule '" + rule.key())
                        .isNotNull();
            }
        }

        assertThat(p3cRepo.name()).isEqualTo(PmdConstants.REPOSITORY_P3C_NAME);
        assertThat(p3cRepo.language()).isEqualTo(PmdConstants.LANGUAGE_KEY);
        List<Rule> rules2 = p3cRepo.rules();
        assertThat(rules2).hasSize(56);
        for (Rule rule : rules2) {
            assertThat(rule.key()).isNotNull();
            assertThat(rule.internalKey()).isNotNull();
            assertThat(rule.name()).isNotNull();
            assertThat(rule.htmlDescription()).isNotNull();
            assertThat(rule.severity()).isNotNull();

            for (Param param : rule.params()) {
                assertThat(param.name()).isNotNull();
                assertThat(param.description())
                        .overridingErrorMessage("Description is not set for parameter '" + param.name() + "' of rule '" + rule.key())
                        .isNotNull();
            }
        }
    }

    @Test
    void should_exclude_junit_rules() {
        PmdP3cRulesDefinition definition = new PmdP3cRulesDefinition();
        RulesDefinition.Context context = new RulesDefinition.Context();
        definition.define(context);
        RulesDefinition.Repository repository = context.repository(PmdConstants.REPOSITORY_KEY);

        for (Rule rule : repository.rules()) {
            assertThat(rule.key()).doesNotContain("JUnitStaticSuite");
        }

        RulesDefinition.Repository repository2 = context.repository(PmdConstants.REPOSITORY_P3C_KEY);

        for (Rule rule : repository2.rules()) {
            assertThat(rule.key()).doesNotContain("JUnitStaticSuite");
        }
    }

    @Test
    void should_use_text_parameter_for_xpath_rule() {
        PmdP3cRulesDefinition definition = new PmdP3cRulesDefinition();
        RulesDefinition.Context context = new RulesDefinition.Context();
        definition.define(context);
        RulesDefinition.Repository repository = context.repository(PmdConstants.REPOSITORY_KEY);
        Rule xpathRule = Iterables.find(repository.rules(), rule -> rule.key().equals("XPathRule"));
        assertThat(xpathRule.param("xpath").type().type()).isEqualTo(PropertyType.TEXT.name());
    }
}
