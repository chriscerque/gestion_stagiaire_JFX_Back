package net.ent.etrs.gestion_stagiaire.model.converters;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

//@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDate) {
        return localDate != null ? Timestamp.valueOf(localDate) : null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp date) {

        return date != null ? date.toLocalDateTime() : null;
    }
}
