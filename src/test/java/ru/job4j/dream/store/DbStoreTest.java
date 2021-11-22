package ru.job4j.dream.store;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

public class DbStoreTest {
    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenDeletePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        store.deletePost(post.getId());
        Post postInDb = store.findPostById(post.getId());
        assertNull(postInDb);
    }

    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Alex");
        store.saveCandidate(candidate);
        Candidate candInDb = store.findCandidateById(candidate.getId());
        assertThat(candInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenDeleteCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Petr");
        store.saveCandidate(candidate);
        store.deleteCandidate(candidate.getId());
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertNull(candidateInDb);
    }

    @Test
    public void whenUpdateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Alex");
        store.saveCandidate(candidate);
        store.saveCandidate(candidate);
        Candidate candInPsql = store.findCandidateById(candidate.getId());
        assertThat(candInPsql.getName(), is(candidate.getName()));
    }

    @Test
    public void whenUpdatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Junior");
        store.savePost(post);
        store.savePost(post);
        Post postInPsql = store.findPostById(post.getId());
        assertThat(postInPsql.getName(), is(post.getName()));
    }
}