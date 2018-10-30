using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using fortune_teller_service.Models;

namespace fortune_teller_service.Repositories
{
    public class FortuneRepository : IFortuneRepository
    {
        private FortuneContext _db;
        private Random _random;

        public FortuneRepository(FortuneContext db)
        {
            this._db = db;
        }

        public IEnumerable<Fortune> GetAll()
        {
            return this._db.Fortunes.AsEnumerable();
        }

        public Fortune RandomFortune()
        {
            var count = this._db.Fortunes.Count();
            var index = this._random.Next() % count;
            return GetAll().ElementAt(index);
        }
    }
}