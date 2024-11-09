package umc.spring.domain.image;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReportImage is a Querydsl query type for ReportImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReportImage extends EntityPathBase<ReportImage> {

    private static final long serialVersionUID = 1579305288L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReportImage reportImage = new QReportImage("reportImage");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.report.QReport report;

    public QReportImage(String variable) {
        this(ReportImage.class, forVariable(variable), INITS);
    }

    public QReportImage(Path<? extends ReportImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReportImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReportImage(PathMetadata metadata, PathInits inits) {
        this(ReportImage.class, metadata, inits);
    }

    public QReportImage(Class<? extends ReportImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.report = inits.isInitialized("report") ? new umc.spring.domain.report.QReport(forProperty("report"), inits.get("report")) : null;
    }

}

