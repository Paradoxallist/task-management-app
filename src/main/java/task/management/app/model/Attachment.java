package task.management.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE attachments SET is_deleted = TRUE WHERE id = ?")
@SQLRestriction(value = "is_deleted = FALSE")
@Table(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "taskId", nullable = false)
    private Long taskId;

    @Column(name = "dropboxFileId", nullable = false)
    private String dropboxFileId;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "uploadDate", nullable = false)
    private LocalDateTime uploadDate;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
