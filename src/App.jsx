import {
  BrowserRouter as Router, Routes, Route,
} from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
const App = () => {
  return (
    <main className='bg-slate-300/20'>
      <Router>

        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/login' element={<Login />} />
        </Routes>
      </Router>
    </main>
  )
}

export default App
