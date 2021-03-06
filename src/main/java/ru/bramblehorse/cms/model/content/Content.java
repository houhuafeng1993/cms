package ru.bramblehorse.cms.model.content;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 20.09.13
 * Time: 23:07
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "content")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Content implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Integer contentId;
    @Column(name = "content_position")
    private Integer contentPosition;
    @Column(name = "content_type")
    protected ContentType type = ContentType.NONE;
    @Column(name = "is_visible")
    private boolean isVisible;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Integer getContentPosition() {
        return contentPosition;
    }

    public void setContentPosition(Integer contentPosition) {
        this.contentPosition = contentPosition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public ContentType getType() {
        return type;
    }

    protected void setType(ContentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content)) return false;

        Content content = (Content) o;

        if (!contentId.equals(content.contentId)) return false;

        return true;
    }

    @Override
    public int hashCode() {

        return 11 * contentId.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (o == null)
            throw new NullPointerException("Passed null to ru.bramblehorse.cms.model.content.Content#compareTo(Object)");
        if(!(o instanceof Content))
            throw new ClassCastException("ru.bramblehorse.cms.model.content.Content#compareTo(Object)");
        if(((Content) o).getContentPosition() < this.getContentPosition()) return 1;
        if(((Content) o).getContentPosition() > this.getContentPosition()) return -1;
        return 0;
    }
}
