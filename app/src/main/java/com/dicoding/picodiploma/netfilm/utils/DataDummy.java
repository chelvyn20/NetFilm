package com.dicoding.picodiploma.netfilm.utils;

import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieCastItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieDetailResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieGenreItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieProducerItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowCastItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowCreatorItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowDetailResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowGenreItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowNetworkItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowProducerItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public class DataDummy {
    public static ArrayList<TvShowSimpleEntity> createDummySimpleTvShows() {
        ArrayList<TvShowSimpleEntity> tvShows = new ArrayList<>();

        tvShows.add(new TvShowSimpleEntity(
                1399,
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Game of Thrones",
                "2011-04-17",
                8.4,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond."
        ));

        tvShows.add(new TvShowSimpleEntity(
                85271,
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "WandaVision",
                "2021-01-15",
                8.5,
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems."
        ));

        tvShows.add(new TvShowSimpleEntity(
                60735,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                "2014-10-07",
                7.6,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
        ));

        tvShows.add(new TvShowSimpleEntity(
                69050,
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Riverdale",
                "2017-01-26",
                8.6,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade."
        ));

        tvShows.add(new TvShowSimpleEntity(
                95057,
                "/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg",
                "Superman & Lois",
                "2021-02-23",
                8.4,
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society."
        ));

        tvShows.add(new TvShowSimpleEntity(
                1402,
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                "The Walking Dead",
                "2010-10-31",
                8,
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way."
        ));

        tvShows.add(new TvShowSimpleEntity(
                71712,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "The Good Doctor",
                "2017-09-25",
                8.6,
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives"
        ));

        tvShows.add(new TvShowSimpleEntity(
                1416,
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Grey's Anatomy",
                "2005-03-27",
                8.2,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital."
        ));

        tvShows.add(new TvShowSimpleEntity(
                63174,
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Lucifer",
                "2016-01-25",
                8.5,
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape."
        ));

        tvShows.add(new TvShowSimpleEntity(
                93693,
                "/seCdnVx50nhHmDqaC6QEYM3jSG3.jpg",
                "Are You Afraid of the Dark?",
                "2019-10-11",
                7.6,
                "Each season of this horror anthology series follows a different group of kids, members of the Midnight Society, as they discover terrifying curses and creatures."
        ));

        return tvShows;
    }

    public static ArrayList<MovieSimpleEntity> createDummySimpleMovies() {
        ArrayList<MovieSimpleEntity> movies = new ArrayList<>();

        movies.add(new MovieSimpleEntity(
                458576,
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Monster Hunter",
                "2020-12-03",
                7.3,
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home."
        ));

        movies.add(new MovieSimpleEntity(
                527774,
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "Raya and the Last Dragon",
                "2021-03-03",
                8.6,
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people."
        ));

        movies.add(new MovieSimpleEntity(
                587807,
                "/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
                "Tom & Jerry",
                "2021-02-11",
                7.7,
                "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse."
        ));

        movies.add(new MovieSimpleEntity(
                484718,
                "/nWBPLkqNApY5pgrJFMiI9joSI30.jpg",
                "Coming 2 America",
                "2021-03-05",
                7.1,
                "Prince Akeem Joffer is set to become King of Zamunda when he discovers he has a son he never knew about in America – a street savvy Queens native named Lavelle. Honoring his royal father's dying wish to groom this son as the crown prince, Akeem and Semmi set off to America once again."
        ));

        movies.add(new MovieSimpleEntity(
                458576,
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Monster Hunter",
                "2020-12-03",
                7.3,
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home."
        ));

        movies.add(new MovieSimpleEntity(
                464052,
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "Wonder Woman 1984",
                "2020-12-16",
                6.9,
                "A botched store robbery places Wonder Woman in a global battle against a powerful and mysterious ancient force that puts her powers in jeopardy."
        ));

        movies.add(new MovieSimpleEntity(
                581389,
                "/y2Yp7KC2FJSsdlRM5qkkIwQGCqU.jpg",
                "Space Sweepers",
                "2021-02-05",
                7.4,
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake."
        ));

        movies.add(new MovieSimpleEntity(
                649087,
                "/xZ2KER2gOHbuHP2GJoODuXDSZCb.jpg",
                "Red Dot",
                "2021-02-11",
                6.4,
                "On a hiking trip to rekindle their marriage, a couple find themselves fleeing for their lives in the unforgiving wilderness from an unknown shooter."
        ));

        movies.add(new MovieSimpleEntity(
                775996,
                "/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg",
                "Outside the Wire",
                "2021-01-15",
                6.5,
                "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device."
        ));

        movies.add(new MovieSimpleEntity(
                602269,
                "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                "The Little Things",
                "2021-01-28",
                6.5,
                "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case."
        ));

        return movies;
    }


    public static ArrayList<TvShowDetailEntity> createDummyDetailTvShows() {
        ArrayList<TvShowDetailEntity> tvShows = new ArrayList<>();

        tvShows.add(new TvShowDetailEntity(
                1399,
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Game of Thrones",
                "2011-04-17",
                8.4,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                false,
                8,
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                "HBO",
                "Revolution Sun Studios, Television 360, Generator Entertainment, Bighead Littlehead",
                "David Benioff, D. B. Weiss"
        ));

        tvShows.add(new TvShowDetailEntity(
                85271,
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "WandaVision",
                "2021-01-15",
                8.5,
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                false,
                1,
                "Sci-Fi & Fantasy, Mystery, Drama",
                "Disney+",
                "Marvel Studios",
                "Jac Schaeffer"
        ));

        tvShows.add(new TvShowDetailEntity(
                60735,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                "2014-10-07",
                7.6,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                false,
                7,
                "Drama, Sci-Fi & Fantasy",
                "The CW",
                "Warner Bros. Television, Berlanti Productions, DC Entertainment, Mad Ghost Productions",
                "Greg Berlanti, Geoff Johns, Andrew Kreisberg"
        ));

        tvShows.add(new TvShowDetailEntity(
                69050,
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Riverdale",
                "2017-01-26",
                8.6,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                false,
                5,
                "Mystery, Drama, Crime",
                "The CW",
                "Warner Bros. Television, Berlanti Productions",
                "Roberto Aguirre-Sacasa"
        ));

        tvShows.add(new TvShowDetailEntity(
                95057,
                "/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg",
                "Superman & Lois",
                "2021-02-23",
                8.4,
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                false,
                1,
                "Action & Adventure, Sci-Fi & Fantasy",
                "The CW",
                "Warner Bros. Television, Berlanti Productions, DC Entertainment",
                "Greg Berlanti, Todd Helbing"
        ));

        tvShows.add(new TvShowDetailEntity(
                1402,
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                "The Walking Dead",
                "2010-10-31",
                8,
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                false,
                10,
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "AMC",
                "AMC Networks, Circle of Confusion, Valhalla Motion Pictures, Darkwoods Productions",
                "Frank Darabont"
        ));

        tvShows.add(new TvShowDetailEntity(
                71712,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "The Good Doctor",
                "2017-09-25",
                8.6,
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                false,
                4,
                "Drama",
                "ABC",
                "ABC Studios, 3AD",
                "David Shore"
        ));

        tvShows.add(new TvShowDetailEntity(
                1416,
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Grey's Anatomy",
                "2005-03-27",
                8.2,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                false,
                17,
                "Drama",
                "ABC",
                "The Mark Gordon Company, ShondaLand, ABC Studios, Touchstone Television",
                "Shonda Rhimes"
        ));

        tvShows.add(new TvShowDetailEntity(
                63174,
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Lucifer",
                "2016-01-25",
                8.5,
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                false,
                5,
                "Crime, Sci-Fi & Fantasy",
                "FOX, Netflix",
                "Fox Productions, Warner Bros. Television, Aggressive Mediocrity, DC Entertainment, Jerry Bruckheimer Television",
                "Tom Kapinos"
        ));

        tvShows.add(new TvShowDetailEntity(
                93693,
                "/seCdnVx50nhHmDqaC6QEYM3jSG3.jpg",
                "Are You Afraid of the Dark?",
                "2019-10-11",
                7.6,
                "Each season of this horror anthology series follows a different group of kids, members of the Midnight Society, as they discover terrifying curses and creatures.",
                false,
                2,
                "Mystery",
                "Nickelodeon",
                null,
                "BenDavid Grabinski"
        ));

        return tvShows;
    }

    public static ArrayList<MovieDetailEntity> createDummyDetailMovies() {
        ArrayList<MovieDetailEntity> movies = new ArrayList<>();

        movies.add(new MovieDetailEntity(
                458576,
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Monster Hunter",
                "2020-12-03",
                7.3,
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                false,
                104,
                "Fantasy, Action, Adventure",
                60000000,
                25814306,
                "CAPCOM, Constantin Film, Impact Pictures, Tencent Pictures, Toho Company, Ltd., Screen Gems, Sony Pictures"
        ));

        movies.add(new MovieDetailEntity(
                527774,
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "Raya and the Last Dragon",
                "2021-03-03",
                8.6,
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                false,
                112,
                "Animation, Adventure, Fantasy, Family, Action, Drama",
                0,
                0,
                "Walt Disney Pictures, Walt Disney Animation Studios"
        ));

        movies.add(new MovieDetailEntity(
                587807,
                "/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
                "Tom & Jerry",
                "2021-02-11",
                7.7,
                "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                false,
                101,
                "Action, Comedy, Family, Animation, Adventure",
                50000000,
                10,
                "Warner Animation Group, Warner Bros. Pictures, Turner Entertainment, The Story Company"
        ));

        movies.add(new MovieDetailEntity(
                484718,
                "/nWBPLkqNApY5pgrJFMiI9joSI30.jpg",
                "Coming 2 America",
                "2021-03-05",
                7.1,
                "Prince Akeem Joffer is set to become King of Zamunda when he discovers he has a son he never knew about in America – a street savvy Queens native named Lavelle. Honoring his royal father's dying wish to groom this son as the crown prince, Akeem and Semmi set off to America once again.",
                false,
                110,
                "Comedy",
                60000000,
                0,
                "Paramount, New Republic static Pictures, Eddie Murphy Productions, Misher Films, Amazon Studios"
        ));

        movies.add(new MovieDetailEntity(
                458576,
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Monster Hunter",
                "2020-12-03",
                7.3,
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                false,
                104,
                "Fantasy, Action, Adventure",
                60000000,
                25814306,
                "CAPCOM, Constantin Film, Impact Pictures, Tencent Pictures, Toho Company, Ltd., Screen Gems, Sony Pictures"
        ));

        movies.add(new MovieDetailEntity(
                464052,
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "Wonder Woman 1984",
                "2020-12-16",
                6.9,
                "A botched store robbery places Wonder Woman in a global battle against a powerful and mysterious ancient force that puts her powers in jeopardy.",
                false,
                151,
                "Fantasy, Action, Adventure",
                200000000,
                159533000,
                "DC Entertainment, Warner Bros. Pictures, The Stone Quarry, DC Films, Atlas Entertainment, DC Comics"
        ));

        movies.add(new MovieDetailEntity(
                581389,
                "/y2Yp7KC2FJSsdlRM5qkkIwQGCqU.jpg",
                "Space Sweepers",
                "2021-02-05",
                7.4,
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                false,
                136,
                "Drama, Fantasy, Science Fiction",
                21000000,
                0,
                "Bidangil Pictures, Merry Christmas"
        ));

        movies.add(new MovieDetailEntity(
                649087,
                "/xZ2KER2gOHbuHP2GJoODuXDSZCb.jpg",
                "Red Dot",
                "2021-02-11",
                6.4,
                "On a hiking trip to rekindle their marriage, a couple find themselves fleeing for their lives in the unforgiving wilderness from an unknown shooter.",
                false,
                86,
                "Drama, Thriller",
                0,
                0,
                "Film i Dalarna, SF Studio"
        ));

        movies.add(new MovieDetailEntity(
                775996,
                "/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg",
                "Outside the Wire",
                "2021-01-15",
                6.5,
                "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
                false,
                116,
                "Thriller, Action, Science Fiction",
                0,
                0,
                "Inspire Entertainment, Automatik Entertainment, Pioneer Stilking Films, Leeding Media"
        ));

        movies.add(new MovieDetailEntity(
                602269,
                "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                "The Little Things",
                "2021-01-28",
                6.5,
                "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case.",
                false,
                128,
                "Thriller, Crime",
                30000000,
                23205000,
                "Warner Bros. Pictures, Gran Via Productions"
        ));

        return movies;
    }


    public static TvShowCastEntity createDummyCastTvShow() {
        return new TvShowCastEntity(
                1399, "Emilia Clarke, Lena Headey, Sophie Turner, Kit Harington, Peter Dinklage, Nikolaj Coster-Waldau, Maisie Williams, Liam Cunningham, John Bradley, Conleth Hill, Gwendoline Christie, Isaac Hempstead-Wright, Jacob Anderson, Jerome Flynn, Rory McCann, Joe Dempsie"
        );
    }

    public static MovieCastEntity createDummyCastMovie() {
        return new MovieCastEntity(
                458576, "Milla Jovovich, Tony Jaa, T.I., Ron Perlman, Diego Boneta, Meagan Good, Josh Helman, Jin Au-Yeung, Jannik Schümann, Hirona Yamazaki, Nic Rasenti, Nanda Costa, Aaron Beelner, Schelaine Bennett, Adrián Muñoz, Clyde Berning, Paul Hampshire, Bart Fouche, Pope Jerrod"
        );
    }


    public static ArrayList<TvShowResponse> createTvShowResponses() {
        ArrayList<TvShowResponse> tvShows = new ArrayList<>();

        tvShows.add(new TvShowResponse(
                1399,
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Game of Thrones",
                "2011-04-17",
                8.4,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond."
        ));

        tvShows.add(new TvShowResponse(
                85271,
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "WandaVision",
                "2021-01-15",
                8.5,
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems."
        ));

        tvShows.add(new TvShowResponse(
                60735,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                "2014-10-07",
                7.6,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
        ));

        tvShows.add(new TvShowResponse(
                69050,
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Riverdale",
                "2017-01-26",
                8.6,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade."
        ));

        tvShows.add(new TvShowResponse(
                95057,
                "/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg",
                "Superman & Lois",
                "2021-02-23",
                8.4,
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society."
        ));

        tvShows.add(new TvShowResponse(
                1402,
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                "The Walking Dead",
                "2010-10-31",
                8,
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way."
        ));

        tvShows.add(new TvShowResponse(
                71712,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "The Good Doctor",
                "2017-09-25",
                8.6,
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives"
        ));

        tvShows.add(new TvShowResponse(
                1416,
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Grey's Anatomy",
                "2005-03-27",
                8.2,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital."
        ));

        tvShows.add(new TvShowResponse(
                63174,
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Lucifer",
                "2016-01-25",
                8.5,
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape."
        ));

        tvShows.add(new TvShowResponse(
                93693,
                "/seCdnVx50nhHmDqaC6QEYM3jSG3.jpg",
                "Are You Afraid of the Dark?",
                "2019-10-11",
                7.6,
                "Each season of this horror anthology series follows a different group of kids, members of the Midnight Society, as they discover terrifying curses and creatures."
        ));

        return tvShows;
    }

    public static ArrayList<MovieResponse> createMovieResponses() {
        ArrayList<MovieResponse> movies = new ArrayList<>();


        movies.add(new MovieResponse(
                458576,
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Monster Hunter",
                "2020-12-03",
                7.3,
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home."
        ));

        movies.add(new MovieResponse(
                527774,
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "Raya and the Last Dragon",
                "2021-03-03",
                8.6,
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people."
        ));

        movies.add(new MovieResponse(
                587807,
                "/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
                "Tom & Jerry",
                "2021-02-11",
                7.7,
                "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse."
        ));

        movies.add(new MovieResponse(
                484718,
                "/nWBPLkqNApY5pgrJFMiI9joSI30.jpg",
                "Coming 2 America",
                "2021-03-05",
                7.1,
                "Prince Akeem Joffer is set to become King of Zamunda when he discovers he has a son he never knew about in America – a street savvy Queens native named Lavelle. Honoring his royal father's dying wish to groom this son as the crown prince, Akeem and Semmi set off to America once again."
        ));

        movies.add(new MovieResponse(
                458576,
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Monster Hunter",
                "2020-12-03",
                7.3,
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home."
        ));

        movies.add(new MovieResponse(
                464052,
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "Wonder Woman 1984",
                "2020-12-16",
                6.9,
                "A botched store robbery places Wonder Woman in a global battle against a powerful and mysterious ancient force that puts her powers in jeopardy."
        ));

        movies.add(new MovieResponse(
                581389,
                "/y2Yp7KC2FJSsdlRM5qkkIwQGCqU.jpg",
                "Space Sweepers",
                "2021-02-05",
                7.4,
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake."
        ));

        movies.add(new MovieResponse(
                649087,
                "/xZ2KER2gOHbuHP2GJoODuXDSZCb.jpg",
                "Red Dot",
                "2021-02-11",
                6.4,
                "On a hiking trip to rekindle their marriage, a couple find themselves fleeing for their lives in the unforgiving wilderness from an unknown shooter."
        ));

        movies.add(new MovieResponse(
                775996,
                "/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg",
                "Outside the Wire",
                "2021-01-15",
                6.5,
                "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device."
        ));

        movies.add(new MovieResponse(
                602269,
                "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                "The Little Things",
                "2021-01-28",
                6.5,
                "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case."
        ));

        return movies;
    }


    public static TvShowDetailResponse createTvShowDetailResponse() {
        List<TvShowDetailEntity> tvShowDetailEntities = createDummyDetailTvShows();

        ArrayList<TvShowGenreItem> genreItems = new ArrayList<>();
        genreItems.add(new TvShowGenreItem(tvShowDetailEntities.get(0).getTsGenre()));

        ArrayList<TvShowNetworkItem> networkItems = new ArrayList<>();
        networkItems.add(new TvShowNetworkItem(tvShowDetailEntities.get(0).getTsPublisher()));

        ArrayList<TvShowProducerItem> producerItems = new ArrayList<>();
        producerItems.add(new TvShowProducerItem(tvShowDetailEntities.get(0).getTsProducer()));

        ArrayList<TvShowCreatorItem> creatorItems = new ArrayList<>();
        creatorItems.add(new TvShowCreatorItem(tvShowDetailEntities.get(0).getTsCreator()));

        return new TvShowDetailResponse(
                tvShowDetailEntities.get(0).getTsId(),
                tvShowDetailEntities.get(0).getTsPoster(),
                tvShowDetailEntities.get(0).getTsTitle(),
                tvShowDetailEntities.get(0).getTsFirstDate(),
                tvShowDetailEntities.get(0).getTsRating(),
                tvShowDetailEntities.get(0).getTsDescription(),
                genreItems,
                tvShowDetailEntities.get(0).getTsSeason(),
                networkItems,
                producerItems,
                creatorItems
        );
    }

    public static MovieDetailResponse createMovieDetailResponse() {
        List<MovieDetailEntity> movieDetailEntities = createDummyDetailMovies();

        ArrayList<MovieGenreItem> genreItems = new ArrayList<>();
        genreItems.add(new MovieGenreItem(movieDetailEntities.get(0).getMvGenre()));

        ArrayList<MovieProducerItem> producerItems = new ArrayList<>();
        producerItems.add(new MovieProducerItem(movieDetailEntities.get(0).getMvProducer()));

        return new MovieDetailResponse(
                movieDetailEntities.get(0).getMvId(),
                movieDetailEntities.get(0).getMvPoster(),
                movieDetailEntities.get(0).getMvTitle(),
                movieDetailEntities.get(0).getMvReleaseDate(),
                movieDetailEntities.get(0).getMvRating(),
                movieDetailEntities.get(0).getMvDescription(),
                movieDetailEntities.get(0).getMvDuration(),
                genreItems,
                movieDetailEntities.get(0).getMvBudget(),
                movieDetailEntities.get(0).getMvRevenue(),
                producerItems
        );
    }


    public static TvShowCastResponse createTvShowCastResponse() {
        ArrayList<TvShowCastItem> tvShowCastItems = new ArrayList<>();

        tvShowCastItems.add(new TvShowCastItem("Emilia Clarke"));
        tvShowCastItems.add(new TvShowCastItem("Lena Headey"));
        tvShowCastItems.add(new TvShowCastItem("Sophie Turner"));
        tvShowCastItems.add(new TvShowCastItem("Kit Harington"));
        tvShowCastItems.add(new TvShowCastItem("Peter Dinklage"));
        tvShowCastItems.add(new TvShowCastItem("Nikolaj Coster-Waldau"));
        tvShowCastItems.add(new TvShowCastItem("Maisie Williams"));
        tvShowCastItems.add(new TvShowCastItem("Liam Cunningham"));
        tvShowCastItems.add(new TvShowCastItem("John Bradley"));
        tvShowCastItems.add(new TvShowCastItem("Conleth Hill"));
        tvShowCastItems.add(new TvShowCastItem("Gwendoline Christie"));
        tvShowCastItems.add(new TvShowCastItem("Isaac Hempstead-Wright"));
        tvShowCastItems.add(new TvShowCastItem("Jacob Anderson"));
        tvShowCastItems.add(new TvShowCastItem("Jerome Flynn"));
        tvShowCastItems.add(new TvShowCastItem("Rory McCann"));
        tvShowCastItems.add(new TvShowCastItem("Joe Dempsie"));

        return new TvShowCastResponse(1399, tvShowCastItems);
    }

    public static MovieCastResponse createMovieCastResponse() {
        ArrayList<MovieCastItem> movieCastItems = new ArrayList<>();

        movieCastItems.add(new MovieCastItem("Milla Jovovich"));
        movieCastItems.add(new MovieCastItem("Tony Jaa"));
        movieCastItems.add(new MovieCastItem("T.I."));
        movieCastItems.add(new MovieCastItem("Ron Perlman"));
        movieCastItems.add(new MovieCastItem("Diego Boneta"));
        movieCastItems.add(new MovieCastItem("Meagan Good"));
        movieCastItems.add(new MovieCastItem("Josh Helman"));
        movieCastItems.add(new MovieCastItem("Jin Au-Yeung"));
        movieCastItems.add(new MovieCastItem("Jannik Schümann"));
        movieCastItems.add(new MovieCastItem("Hirona Yamazaki"));
        movieCastItems.add(new MovieCastItem("Nic Rasenti"));
        movieCastItems.add(new MovieCastItem("Nanda Costa"));
        movieCastItems.add(new MovieCastItem("Aaron Beelner"));
        movieCastItems.add(new MovieCastItem("Schelaine Bennett"));
        movieCastItems.add(new MovieCastItem("Adrián Muñoz"));
        movieCastItems.add(new MovieCastItem("Clyde Berning"));
        movieCastItems.add(new MovieCastItem("Paul Hampshire"));
        movieCastItems.add(new MovieCastItem("Bart Fouche"));
        movieCastItems.add(new MovieCastItem("Pope Jerrod"));

        return new MovieCastResponse(458576, movieCastItems);
    }

    public static TvShowDetailEntity generateDummyDetailTvShow(TvShowDetailEntity detailTvShow, boolean state) {
        detailTvShow.setTsFavorite(state);
        return detailTvShow;
    }

    public static MovieDetailEntity generateDummyDetailMovie(MovieDetailEntity detailMovie, boolean state) {
        detailMovie.setMvFavorite(state);
        return detailMovie;
    }
}
