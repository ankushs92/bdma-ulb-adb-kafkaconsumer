package bdma.ulb.adb.kcclickspersistence.repository

import bdma.ulb.adb.kcclickspersistence.domain.Click
import org.springframework.data.cassandra.repository.CassandraRepository

interface ClickRepository extends CassandraRepository<Click> {
}
