package guru.springframework.spring5webapp.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String isBn;
  @ManyToMany
  @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<Author> Authors;

  public Book(String title) {
    this.title = title;
  }

  public Book(String title, String isBn, Set<Author> authors) {
    this.title = title;
    this.isBn = isBn;
    Authors = authors;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsBn() {
    return isBn;
  }

  public void setIsBn(String isBn) {
    this.isBn = isBn;
  }

  public Set<Author> getAuthors() {
    return Authors;
  }

  public void setAuthors(Set<Author> authors) {
    Authors = authors;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", isBn='" + isBn + '\'' +
        ", Authors=" + Authors +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    return Objects.equals(id, book.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}

