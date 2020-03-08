package com.mkyong.entitygraph;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MOVIE_ENTITY_GRAPH")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")
})
@NamedEntityGraphs({
    @NamedEntityGraph(
        name = "movieWithActors",
        attributeNodes = {
            @NamedAttributeNode("movieActors")
        }
    ),
    @NamedEntityGraph(
        name = "movieWithActorsAndAwards",
        attributeNodes = {
            @NamedAttributeNode(value = "movieActors", subgraph = "movieActorsGraph")
        },
        subgraphs = {
            @NamedSubgraph(
                    name = "movieActorsGraph",
                    attributeNodes = {
                        @NamedAttributeNode("movieActorAwards")
                    }
            )
        }
    )
})
//https://github.com/javaee-samples/javaee7-samples#how-to-run-
public class Movie implements Serializable {
    @Id
    private Integer id;

    @NotNull
    @Size(max = 50)
    private String name;

    @OneToMany
    @JoinColumn(name = "ID")
    private Set<MovieActor> movieActors;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    private Set<MovieDirector> movieDirectors;

    @OneToMany
    @JoinColumn(name = "ID")
    private Set<MovieAward> movieAwards;
}
