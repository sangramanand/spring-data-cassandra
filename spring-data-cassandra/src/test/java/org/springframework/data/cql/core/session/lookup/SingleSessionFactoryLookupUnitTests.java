/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.cql.core.session.lookup;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.springframework.data.cql.core.session.SessionFactory;

/**
 * Unit tests for {@link SingleSessionFactoryLookup}.
 *
 * @author Mark Paluch
 */
public class SingleSessionFactoryLookupUnitTests {

	@Test(expected = IllegalArgumentException.class) // DATACASS-330
	public void shouldRejectNullSessionFactory() {
		new SingleSessionFactoryLookup(null);
	}

	@Test // DATACASS-330
	public void shouldResolveSessionFactory() {

		SessionFactory sessionFactory = mock(SessionFactory.class);
		SessionFactory result = new SingleSessionFactoryLookup(sessionFactory).getSessionFactory("any");

		assertThat(result).isSameAs(sessionFactory);
	}
}
