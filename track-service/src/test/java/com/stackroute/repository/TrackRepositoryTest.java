// package com.stackroute.repository;


// import com.stackroute.domain.Track;
// import org.junit.After;
// import org.junit.Assert;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
// import org.springframework.test.context.junit4.SpringRunner;

// import java.util.ArrayList;
// import java.util.List;

// /**
//  * @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit
//  */
// @RunWith(SpringRunner.class)
// /**Using @DataMongoTest annotation will disable full auto-configuration and instead apply only configuration relevant to MongoDB tests.
//  */
// @DataMongoTest
// public class TrackRepositoryTest {

//     /**
//      * Used AutoWire by property to inject TrackRepository here
//      */
//     @Autowired
//     private TrackRepository trackRepository;
//     private Track track;


//     /**
//      * Execute this before each test case
//      */
//     @Before
//     public void setUp() {
//         //Add new track by setter methods
//         track = new Track();
//         track.setId(1);
//         track.setTrackName("Music track1");
//         track.setComments("Music comment1");

//     }

//     /**
//      * Execute this after every test case
//      */
//     @After
//     public void tearDown() {
//         //Free the repository after every test case
//         trackRepository.deleteAll();
//         this.track = null;
//     }


//     @Test
//     public void givenTrackShouldSaveThatTrack() {
//         //assert
//         Assert.assertEquals(track, trackRepository.save(track));

//     }

//     @Test
//     public void givenTrackShouldSaveTrackFailure() {
//         //act
//         Track expectedTrack = new Track(1, "Music track1", "comment");
//         //assert
//         Assert.assertNotSame(expectedTrack, trackRepository.save(track));

//     }

//     @Test
//     public void givenTrackIdShouldReturnTrackOfThatId() {
//         //act
//         trackRepository.save(track);
//         Track actualResult = trackRepository.findById(track.getId()).get();
//         //assert
//         Assert.assertEquals(track, actualResult);
//     }

//     @Test
//     public void givenTrackIdShouldReturnTrackOfThatIdFailure() {
//         //act
//         Track track1 = new Track(1, "Music track1", "comment");
//         trackRepository.save(track1);
//         Track actualResult = trackRepository.findById(track.getId()).get();
//         //assert
//         Assert.assertNotSame(track, actualResult);
//     }

//     @Test
//     public void givenTracksShouldReturnListOfAllTracks() {
//         //act
//         Track track1 = new Track(1, "Music track1", "comment1");
//         Track track2 = new Track(2, "Music track2", "comment2");
//         trackRepository.save(track1);
//         trackRepository.save(track2);

//         List<Track> list = new ArrayList<>();
//         list.add(track1);
//         list.add(track2);

//         List<Track> actualResult = trackRepository.findAll();
//         //assert
//         Assert.assertEquals(list, actualResult);

//     }

//     @Test
//     public void givenMethodCallToGetAllTracksShouldReturnListOfAllTracksFailure() {
//         Track track1 = new Track(1, "Music track1", "comment1");
//         Track track2 = new Track(2, "Music track2", "comment2");
//         trackRepository.save(track1);
//         trackRepository.save(track2);
//         trackRepository.save(track);

//         List<Track> list = new ArrayList<>();
//         list.add(track1);
//         list.add(track2);

//         List<Track> actualResult = trackRepository.findAll();
//         //assert
//         Assert.assertNotSame(list, actualResult);

//     }

//     @Test
//     public void givenTrackIdTODeleteShouldDeleteTheTrack() {
//         //act
//         trackRepository.deleteById(track.getId());
//         List expectedResult = new ArrayList();
//         //assert
//         Assert.assertEquals(expectedResult, trackRepository.findAll());

//     }

//     @Test
//     public void givenTrackIdShouldDeleteTrackFailure() {
//         //act
//         trackRepository.deleteById(track.getId());
//         //assert
//         Assert.assertNotSame(" ", trackRepository.findById(track.getId()));

//     }

//     @Test
//     public void givenMethodCallToDeleteAllTracksShouldReturnTrue() {
//         //act
//         trackRepository.deleteAll();
//         //assert
//         Assert.assertEquals(true, trackRepository.findAll().isEmpty());

//     }

//     @Test
//     public void givenMethodCallToDeleteAllTracksShouldReturnFalse() {
//         //act
//         trackRepository.deleteAll();
//         //assert
//         Assert.assertEquals(false, !(trackRepository.findAll().isEmpty()));

//     }

//     @Test
//     public void givenTrackShouldReturnUpdatedTrack() {
//         //act
//         trackRepository.save(track);
//         Track getTrack = trackRepository.findById(track.getId()).get();
//         getTrack.setComments("Updated comment");
//         Track track = new Track(1, "Music track1", "Updated comment");
//         //assert
//         Assert.assertEquals(track, getTrack);
//     }

//     @Test
//     public void givenTrackIdShouldReturnUpdatedTrackFailure() {
//         //act
//         trackRepository.save(track);
//         Track getTrack = trackRepository.findById(track.getId()).get();
//         getTrack.setComments("Updated comment");
//         //assert
//         Assert.assertNotSame(track, getTrack);
//     }

//     @Test
//     public void givenTrackNameShouldReturnTracksWithThatName() {
//         //act
//         trackRepository.save(track);
//         List<Track> expectedResult = new ArrayList<>();
//         expectedResult.add(track);
//         //assert
//         Assert.assertEquals(expectedResult, trackRepository.findBytrackName(track.getTrackName()));
//     }

//     @Test
//     public void givenTrackNameShouldReturnTracksWithThatNameFailure() {
//         //act
//         trackRepository.save(track);
//         //assert
//         Assert.assertNotSame(track, trackRepository.findBytrackName(track.getTrackName()));
//     }
// }
