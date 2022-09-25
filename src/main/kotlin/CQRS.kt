/**
 * A short deviation into theory:
 *
 * Aggregate --> Aggregate is a pattern described in DDD. It represents a grouping of logically connected
 *               entities belonging to the same context, binding them to one root.
 *               CQRS benefits from the pattern which groups the write domain model. ( providing
 *               transactional guarantees -> on Frontend side this becomes important when
 *               local databases use 2PC transactions.)
 *               Normally Aggregates hold a cached state for better performance, but that is not a
 *               precondition for using CQRS or Aggregates.
 *
 * Projection / Projector --> Projection essentially means representing domain objects in different
 *              shapes and strucures. These Projections of original data are read-only and highly optimzed
 *              to provide an enhanced read experience. Meaning a fast, performant serving of the data.
 *
 */
