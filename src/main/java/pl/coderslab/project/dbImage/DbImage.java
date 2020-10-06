package pl.coderslab.project.dbImage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "images")
@Getter
@Setter
@ToString(exclude = "data") @EqualsAndHashCode(of = "id")
public class DbImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image_name", nullable = false)
    private String ImageName;
    @Column(name = "original_image_name")
    private String originalImageName;
    @Column(name = "content_type", nullable = false)
    private String contentType;
    private Long size;
    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, columnDefinition = "MEDIUMBLOB")
    private byte[] data;

    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }



}
