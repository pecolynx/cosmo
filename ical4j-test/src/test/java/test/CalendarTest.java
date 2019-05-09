package test;

import static org.junit.Assert.assertNotNull;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import net.fortuna.ical4j.connector.ObjectStore;
import net.fortuna.ical4j.connector.ObjectStoreException;
import net.fortuna.ical4j.connector.dav.CalDavCalendarCollection;
import net.fortuna.ical4j.connector.dav.CalDavCalendarStore;
import net.fortuna.ical4j.connector.dav.PathResolver;

public class CalendarTest {

//    private final ObjectStoreLifecycle<CalDavCalendarCollection> lifecycle;


    private ObjectStore<CalDavCalendarCollection> store;

    private String username;

    private char[] password;

    private final String collectionName = "myCollection";

    protected static final String PRODID = "-//Ben Fortuna//iCal4j Connector 1.0//EN";

    URL url;

    @Before
    public void setUp() throws Exception {
        url = new URL("http://localhost:8088");
        store = new CalDavCalendarStore(PRODID, url, PathResolver.CHANDLER);
        store.connect(username, password);

        // ensure collection doesn't exist prior to tests..
        try {
            store.removeCollection(collectionName);
        } catch (Exception e) {
        }
    }

    @Test
    public void test() throws ObjectStoreException {

        String username = "fortuna";
        char[] password = "connector".toCharArray();
        store.connect(username, password);

//        suite.addTest(new ObjectStoreTest<CalDavCalendarCollection>("testAddCollection",
//                                                                    new CalDavCalendarStoreLifecycle(url,
//                                                                                                     PathResolver.CHANDLER),
//                                                                    username, password));
//        suite.addTest(new ObjectStoreTest<CalDavCalendarCollection>("testGetCollection",
//                                                                    new CalDavCalendarStoreLifecycle(url,
//                                                                                                     PathResolver.CHANDLER),
//                                                                    username, password));
//        suite.addTest(new ObjectStoreTest<CalDavCalendarCollection>("testRemoveCollection",
//                                                                    new CalDavCalendarStoreLifecycle(url,
//                                                                                                     PathResolver.CHANDLER),
//                                                                    username, password));
//        return suite;
    }

    public void testAddCollection() throws ObjectStoreException {
        CalDavCalendarCollection collection = store.addCollection(collectionName);
        assertNotNull(collection);
    }
}
