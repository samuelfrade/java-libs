/*
 * Copyright (C) 2004 Rong Chen, Acode HB, Sweden
 * All rights reserved.
 *
 * The contents of this software are subject to the FSF GNU Public License 2.0;
 * you may not use this software except in compliance with the License. You may
 * obtain a copy of the License at http://www.fsf.org/licenses/gpl.html
 *
 * Software distributed under the License is distributed on an 'AS IS' basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 */
package org.openehr.rm.composition;

import junit.framework.TestCase;
import org.openehr.rm.datatypes.quantity.datetime.DvDateTime;
import org.openehr.rm.datatypes.quantity.DvInterval;
import org.openehr.rm.datatypes.text.DvCodedText;
import org.openehr.rm.datatypes.text.CodePhrase;
import org.openehr.rm.support.identification.PartyReference;
import org.openehr.rm.support.identification.HierarchicalObjectID;
import org.openehr.rm.support.terminology.TestTerminologyService;

/**
 * EventContextTest
 *
 * @author Rong Chen
 * @version 1.0
 */
public class EventContextTest extends TestCase {

    /**
     * Tests null checking for setting within the constructor
     *
     * @throws Exception
     */
    public void testCreateEventContextWithNullSetting() throws Exception {
        try {
            DvInterval<DvDateTime> time = new DvInterval<DvDateTime>(
                    new DvDateTime("2002-10-01 10:00:00"),
                    new DvDateTime("2002-10-01 12:30:00"));
            PartyReference composer = new PartyReference(
                    new HierarchicalObjectID("1213453453"));
            new EventContext(null, time, composer, null, null, null, null,
                    TestTerminologyService.getInstance());

            fail("failed to thrown illeglArgumentException for null setting");

        } catch (Exception e) {
            assertTrue("caught unexpected exception: " + e,
                    e instanceof IllegalArgumentException);
            assertTrue("wrong message: " + e.getMessage(),
                    e.getMessage().contains("setting"));
        }
    }

    /**
     * Tests null participations doesn't cause getParticipations throws
     * exception
     *
     * @throws Exception
     */
    public void testGetParticipations() throws Exception {
        DvInterval<DvDateTime> time = new DvInterval<DvDateTime>(
                new DvDateTime("2002-10-01 10:00:00"),
                new DvDateTime("2002-10-01 12:30:00"));
        PartyReference composer = new PartyReference(
                new HierarchicalObjectID("1213453453"));
        DvCodedText setting = new DvCodedText("home",
                new CodePhrase("test term", "23432"));
        EventContext eventContext = new EventContext(null, time, composer,
                null, null, setting, null,
                TestTerminologyService.getInstance());

        eventContext.getParticipations();
    }
}